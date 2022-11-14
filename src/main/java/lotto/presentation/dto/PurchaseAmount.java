package lotto.presentation.dto;

import lotto.support.Validator;

public class PurchaseAmount {
    private final Integer amount;
    public PurchaseAmount(String amount){
        validate(amount);
        this.amount=Integer.parseInt(amount);
    }
    private void validate(String amount){
        Validator.checkInteger(amount);
        Validator.checkUnit(amount);
        Validator.checkBelow(amount);
    }
    public Integer getAmount(){
        return amount;
    }
}
