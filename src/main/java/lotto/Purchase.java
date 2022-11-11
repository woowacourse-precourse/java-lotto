package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private final int price;

    public Purchase(int price) {
        validateDivision(price);
        this.price = price;
    }

    private void validateDivision(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(LottoMessage.PRICE_ERROR_MESSAGE.getMessage());
        }
    }
}
