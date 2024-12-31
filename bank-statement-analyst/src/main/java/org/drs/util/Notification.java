package org.drs.util;

import java.util.ArrayList;
import java.util.List;

//implementar depois
public class Notification {
    private final List<String> errors = new ArrayList<>();


    public String errorMessage() {
        return errors.toString();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void addError(final String error) {
        errors.add(error);
    }
    public List<String> getErrors() {
        return errors;
    }
}
