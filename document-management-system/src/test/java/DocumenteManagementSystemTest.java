import org.drs.Attributes;
import org.drs.Document;
import org.drs.DocumentManagementSystem;
import org.drs.UnknownFileTypeException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.drs.Attributes.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class DocumenteManagementSystemTest {
    private static final String RESOURCES =
            "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE = "Joe Car";

    private DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();
    @Test
    public void shouldImportFile() throws IOException {
        documentManagementSystem.importFile(LETTER);

        final Document document = onlyDocument();
        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldNotImportMissingFile() throws Exception {
        documentManagementSystem.importFile("missing-file.txt");
    }

    @Test
    public void shouldImportReport() throws IOException {
        documentManagementSystem.importFile(REPORT);

        assertIsReport(onlyDocument());

    }

    @Test(expected = UnknownFileTypeException.class)
    public void shouldNotImportUnknownFile() throws Exception
    {
        documentManagementSystem.importFile(RESOURCES + "unknown.txt");
    }

    @Test
    public void shouldImportImageAttributes() throws IOException {
        documentManagementSystem.importFile(XRAY);
        final Document document = onlyDocument();

        assertAttributeEquals(document, WIDTH, "320");
        assertAttributeEquals(document, HEIGHT, "179");
        assertTypeIs("IMAGE", document);
    }

    @Test
    public void shouldImportInvoiceAttributes() throws IOException {
        documentManagementSystem.importFile(INVOICE);
        final Document document = onlyDocument();

        assertAttributeEquals(document, PATIENT, JOE);
        assertAttributeEquals(document, AMOUNT, "$100");
        assertTypeIs("INVOICE", document);
    }

    private void assertIsReport(Document document) {
        assertAttributeEquals(document, PATIENT, JOE);
        assertAttributeEquals(document, BODY,
                "On 5th January 2017 I examined Joe's teeth.\n" +
                        "We discussed his switch from drinking Coke to Diet Coke.\n" +
                        "No new problems were noted with his teeth.");
        assertTypeIs("REPORT", document);

    }

    @Test
    public void shouldImportLetterAttributes() throws Exception
    {
        documentManagementSystem.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributeEquals(document, PATIENT, JOE);
        assertAttributeEquals(document, ADDRESS,
                "123 Fake Street\n" +
                        "Westminster\n" +
                        "London\n" +
                        "United Kingdom");
        assertAttributeEquals(document, BODY,
                "We are writing to you to confirm the re-scheduling of your appointment\n" +
                        "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeIs("LETTER", document);
    }

    @Test
    public void shouldBeAbleToSearchFilesByAttributes() throws Exception
    {
        documentManagementSystem.importFile(LETTER);
        documentManagementSystem.importFile(REPORT);
        documentManagementSystem.importFile(XRAY);

        final List<Document> documents = documentManagementSystem.search("patient:Joe,body:Diet Coke");
        assertThat(documents, hasSize(1));

        assertIsReport(documents.getFirst());
    }

    private void assertTypeIs(final String type, final Document document)
    {
        assertAttributeEquals(document, TYPE, type);
    }

    private void assertAttributeEquals(
            final Document document,
            final String attributeName,
            final String expectedValue)
    {
        assertEquals(
                "Document has the wrong value for " + attributeName,
                expectedValue,
                document.getAttribute(attributeName));
    }

    private Document onlyDocument() {
        final List<Document> documents = documentManagementSystem.contents();
        assertThat(documents, hasSize(1));
        return documents.getFirst();
    }
}
