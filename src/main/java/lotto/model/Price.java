package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.validator.Validator;

public class Price {
    public final int price;

    public Price(String inputPrice) {
        validateInteger(inputPrice);
        int price = convertPriceType(inputPrice);
        validatePrice(price);
        this.price = price;
    }

    private void validateInteger(String inputPrice) {
        try {
            Validator.validateDigit(inputPrice);
        } catch (IllegalArgumentException integerError) {
            ErrorMessage.DIGIT_ERROR_MESSAGE.printMessage();
            throw integerError;
        }
    }

    private void validatePrice(int price) {
        try {
            Validator.validatePrice(price);
        } catch (IllegalArgumentException priceError) {
            ErrorMessage.PRICE_ERROR_MESSAGE.printMessage();
            throw priceError;
        }
    }

    private int convertPriceType(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }

    public int calculateCount() {
        return (price / 1000);
    }
}
