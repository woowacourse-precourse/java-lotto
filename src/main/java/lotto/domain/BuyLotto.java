package lotto.domain;

import java.util.regex.Pattern;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1_000;

    public static int getQuantity(final String number) {
        validateNumber(number);
        int price = Integer.parseInt(number);
        validatePrice(price);
        return price / LOTTO_PRICE;
    }

    private static void validateNumber(final String numbers){
        if (!Pattern.matches("^[0-9]*$", numbers)) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    private static void validatePrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR]Lotto purchase price must be more than 1000 won.");
        }
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]Buy the lotto by 1000 won.");
        }
    }
}
