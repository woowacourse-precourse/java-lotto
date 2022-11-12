package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public final int price;

    public Purchase(String payPrice) {
        validatePrice(payPrice);
        int price = convertStringToInteger(payPrice);
        validateUnderPrice(price);
        validateDivision(price);
        this.price = price;
    }

    private void validatePrice(String payPrice) {
        for (int index = 0; index < payPrice.length(); index++) {
            if (!Character.isDigit(payPrice.charAt(index))) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void validateUnderPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivision(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(GameMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private int convertStringToInteger(String payPrice) {
        return Integer.parseInt(payPrice);
    }

    public int calculateCount() {
        return (price/1000);
    }
}
