package lotto.util;

public abstract class Validator {
    abstract void validate(String userInput) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
