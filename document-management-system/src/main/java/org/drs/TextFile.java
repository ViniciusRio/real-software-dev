package org.drs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static org.drs.Attributes.PATH;

public class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;


    TextFile(File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        lines = Files.lines(file.toPath()).collect(toList());
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Exemplo:
     * Se line = "Caro John Doe" e prefix = "Paciente ", então:
     * prefix.length() = 6.
     * line.substring(6) retorna "John Doe".
     * A entrada no mapa será algo como: "Paciente" -> "John Doe".
     * @param prefix
     * @param attributeName
     */
    void addLineSuffix(final String prefix, final String attributeName) {
        for(final String line: lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    /**
     *
     * Se o predicado verifica se uma linha é vazia (line.isEmpty()),
     * o laço para quando uma linha vazia é encontrada.
     */
    int addLines(final int start, Predicate<String> isEnd, String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;

        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);

            if (isEnd.test(line)) {
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }
}
