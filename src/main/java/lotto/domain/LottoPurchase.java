package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ValidateUtils;

public class LottoPurchase {
    private int money;

    private int LottoPublicationCount;

    public LottoPurchase(String input){
        validate(input);
        computeLottoCount();
    }

    public int getLottoPublicationCount(){
        return this.LottoPublicationCount;
    }

    private void validate(String input){
        isInteger(input);
        isCorrectPrice(input);
        this.money = Integer.parseInt(input);
    }

    private void isInteger(String input) throws IllegalArgumentException{
        if(!ValidateUtils.isNumber(input)){
            ValidateUtils.throwIllegalArgumentException(Constants.INVALID_PURCHASE_INPUT_MESSAGE);
        }
    }

    private void isCorrectPrice(String input){
        int value = Integer.parseInt(input);

        if(value % Constants.LOTTO_PRICE != 0){
            ValidateUtils.throwIllegalArgumentException(Constants.NOT_PRICE_UNIT_PURCHASE_INPUT_MESSAGE);
        }
    }

    private void computeLottoCount(){
        this.LottoPublicationCount = this.money / Constants.LOTTO_PRICE;
    }
}
