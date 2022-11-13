package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public final int price;

    public Purchase(String inputPrice) {
        validatePrice(inputPrice);
        int price = convertPriceType(inputPrice);
        validateUnderPrice(price);
        validateDivision(price);
        this.price = price;
    }

    private void validatePrice(String inputPrice) {
        for (int index = 0; index < inputPrice.length(); index++) {
            if (!Character.isDigit(inputPrice.charAt(index))) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void validateUnderPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(GameMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDivision(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(GameMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private int convertPriceType(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }

    public int calculateCount() {
        return (price / 1000);
    }
}
