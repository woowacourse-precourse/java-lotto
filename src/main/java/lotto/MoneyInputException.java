package lotto;

public class MoneyInputException {
    public static ErrorMessage errorMessage;

    public static void moneyTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(errorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void moneyChangeError(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException(errorMessage.VALUE_ERROR.getErrorLog());
    }
}
