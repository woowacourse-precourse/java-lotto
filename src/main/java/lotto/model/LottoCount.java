package lotto.model;

import static lotto.utils.ExceptionMessage.AMOUNT_NOT_DIVISIBLE_EXCEPTION;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoCount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int calculateLottoCount(){
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount){
        if(amount % LOTTO_PRICE !=0){
            throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE_EXCEPTION);
        }
    }

}
