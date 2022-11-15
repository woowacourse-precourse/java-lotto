package lotto.model.vallidator;

public class NumberValidator {
    public static void validate(String[] numbers) {
        for (String number : numbers) {
            validate(number);
        }
    }

    public static void validate(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberError.NUMBER.message());
        }
    }
}
