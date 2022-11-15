package lotto.view;

import lotto.resource.ErrorType;

public class Error {
    private static final String ERROR = "[ERROR] %s";

    public static void printException(ErrorType type) {
        System.out.println(String.format(ERROR, type.getMessage()));
        throw new IllegalArgumentException();
    }
}
