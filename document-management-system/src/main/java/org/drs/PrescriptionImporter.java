package org.drs;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.drs.Attributes.*;

public class PrescriptionImporter implements Importer {
    private static final String NAME_PREFIX = "Patient ";
    public static final String PRESCRIPTION = "prescription";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, PRESCRIPTION);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "PRESCRIPTION");

        return new Document(attributes);
    }
}
