import org.drs.Attributes;
import org.drs.Document;
import org.drs.DocumentManagementSystem;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class DocumenteManagementSystemTest {
    private static final String RESOURCES =
            "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";

    private DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();
    @Test
    public void shouldImportFile() throws IOException {
        documentManagementSystem.importFile(LETTER);

        final Document document = onlyDocument();
        assertAttributeEquals(document, Attributes.PATH, LETTER);
        assertAttributeEquals(document, Attributes.PATH, "LETTER");
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
