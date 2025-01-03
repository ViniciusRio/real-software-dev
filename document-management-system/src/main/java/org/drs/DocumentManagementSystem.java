package org.drs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class DocumentManagementSystem {
    private final Map<String, Importer> extensionToImporter = new HashMap<>();
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentsView = unmodifiableList(documents);

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());
        extensionToImporter.put("invoice", new InvoiceImporter());

    }
    public void importFile(String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + path);
        }
        // posição da extensão do arquivo
        final int separatorIndex = path.lastIndexOf('.');
        if (separatorIndex != -1) {
            /*
            * verifica se o ponto . está no final do nome do arquivo (caso em que não há uma extensão após o ponto).
            * Exemplo de nome inválido: arquivo.
             */
            if (separatorIndex == path.length()) {
                throw new UnknownFileTypeException("No extension found for file: " + path);
            }
            // ex: documento.txt -> txt
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);
            if (importer == null) {
                throw new UnknownFileTypeException("Unknown extension: " + extension);
            }

            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new UnknownFileTypeException("No extension found for file: " + path);
        }

    }

    public List<Document> contents() {
        return documents;
    }

    public List<Document> search(final String query) {
        return documents.stream()
                .filter(Query.parse(query))
                .collect(Collectors.toList());
    }
}
