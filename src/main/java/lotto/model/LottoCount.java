package lotto.model;

import static lotto.utils.ExceptionMessage.AMOUNT_NOT_DIVISIBLE_EXCEPTION;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;

    private final long amount;

    public LottoCount(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public long calculateLottoCount(){
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(long amount){
        if(amount % LOTTO_PRICE !=0){
            throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE_EXCEPTION);
        }
    }

}
