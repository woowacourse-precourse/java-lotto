package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public final int price;

    public Purchase(int price) {
        validateUnderPrice(price);
        validateDivision(price);
        this.price = price;
    }

    private void validateUnderPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivision(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(LottoMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    public int calculateCount() {
        return (price/1000);
    }
}
