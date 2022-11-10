package lotto;

public class Validation {
    public static void money(String input) {
        validateNull(input);
        validateAllDigit(input);
        validateDividedByThousand(input);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw (new IllegalArgumentException());
        }
    }

    private static void validateAllDigit(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw (new IllegalArgumentException());
            }
        }
    }

    private static void validateDividedByThousand(String input) {
        int number = Integer.parseInt(input);

        if ((number % 1000) != 0) {
            throw (new IllegalArgumentException());
        }
    }
}