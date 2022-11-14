package lotto.Model;

import lotto.Error;

public class Purchase {
    private int price;

    private static final int charZero = 48;
    private static final int charNine = 57;


    public Purchase() {
        price = 0;
    }

    public void setPrice(String price) {
        validatePurchase(price);
        this.price = Integer.parseInt(price);
    }

    public void validatePurchase(String price) throws IllegalArgumentException {
        for (int index = 0; index < price.length(); index++) {
            if (price.charAt(index) >= charZero && price.charAt(index) <= charNine) {
                continue;
            }
            throw new IllegalArgumentException(Error.WRONG_MONEY_TYPE.getMessage());
        }
    }
}
