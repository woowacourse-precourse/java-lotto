package domain;

import domain.enums.ErrorMessage;

public class Buyer {
    public int inputPrice;

    public Buyer(String inputNum) {
        validateNumber(inputNum);
    }

    private void validateNumber(String inputNum) {
        validateDigit(inputNum);
        int price = convertToInt(inputNum);
        validateDiv(price);
        this.inputPrice = price;
    }

    private void validateDigit(String inputNum) {
        for (int index = 0; index < inputNum.length(); index++) {
            if (!Character.isDigit(inputNum.charAt(index))) {
                throw new IllegalArgumentException(ErrorMessage.DATA_TYPE_ERR_MESSAGE.getErrorMessage());
            }
        }
    }

    private void validateDiv(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private int convertToInt(String inputNum) {
        return Integer.parseInt(inputNum);
    }

    public int getTicketCount() {
        return inputPrice / 1000;
    }
}
