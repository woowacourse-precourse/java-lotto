package lotto;

import java.util.regex.Pattern;

public class Price {

    private static final String regex = "^[0-9]*$";
    public final int price;
    public final int amount;

    public Price(String price) {
        validateNumber(price);
        validatePrice(price);
        this.price = Integer.parseInt(price);
        this.amount = this.price / 1000;
    }

    private void validateNumber(String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(Errors.NOT_INCLUDE_CHARACTER.toString());
        }
    }

    private void validatePrice(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(Errors.NOT_DIVIDE_BY_1000.toString());
        }
    }
}
