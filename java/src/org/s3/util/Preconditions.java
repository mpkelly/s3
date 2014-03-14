package org.s3.util;

import static java.text.MessageFormat.format;

public final class Preconditions {
    private Preconditions(){}

    public static void checkState(boolean expression, String message, Object ... args) throws IllegalStateException {
        if(expression) {
            throw new IllegalStateException(format(message, args));
        }
    }

}
