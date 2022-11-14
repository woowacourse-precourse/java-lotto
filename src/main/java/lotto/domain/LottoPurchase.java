package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ValidateUtils;

public class LottoPurchase {

    private int money;

    private int LottoCount;

    public LottoPurchase(String input){
        validate(input);
        computeLottoCount();
    }
    private void validate(String input){
        isInteger(input);
        isCorrectPrice(input);
        this.money = Integer.parseInt(input);
    }

    private void isInteger(String input) throws IllegalArgumentException{
        if(!ValidateUtils.isNumber(input)){
            throw new IllegalArgumentException(Constants.INVALID_PURCHASE_INPUT_MESSAGE);
        }
    }

    private void isCorrectPrice(String input){
        int value = Integer.parseInt(input);

        if(value % Constants.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(Constants.NOT_PRICE_UNIT_PURCHASE_INPUT_MESSAGE);
        }
    }

    private void computeLottoCount(){
        this.LottoCount = this.money / Constants.LOTTO_PRICE;
    }
}
