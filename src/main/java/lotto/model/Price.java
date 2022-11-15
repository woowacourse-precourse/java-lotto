package lotto.model;

import lotto.model.enums.ErrorMessage;

public class Price {
    public int price;

    public Price(String inputPrice) {
        validateDigit(inputPrice);
        int price = convertPriceType(inputPrice);
        validateUnderPrice(price);
        validateDivision(price);
        this.price = price;
    }

    private void validateDigit(String inputPrice) {
        for (int index = 0; index < inputPrice.length(); index++) {
            if (!Character.isDigit(inputPrice.charAt(index))) {
                throw new IllegalArgumentException(ErrorMessage.DIGIT_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void validateUnderPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDivision(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private int convertPriceType(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }

    public int calculateCount() {
        return (price / 1000);
    }
}
