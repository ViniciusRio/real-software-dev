package org.drs;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.drs.Attributes.*;

public class InvoiceImporter implements Importer {
    public static final String NAME_PREFIX = "Dear ";
    public static final String AMOUNT_PREFIX = "Amount: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "INVOICE");

        return new Document(attributes);

    }
}
