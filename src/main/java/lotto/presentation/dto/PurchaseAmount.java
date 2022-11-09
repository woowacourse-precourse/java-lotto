package lotto.presentation.dto;


import lotto.support.Validator;

public class PurchaseAmount {
    private final Validator validator=Validator.getInstance();
    private Integer amount;
    public PurchaseAmount(String amount){
        validate(amount);
        this.amount=Integer.parseInt(amount);
    }
    private void validate(String amount){
        validator.checkInteger(amount);
    }
    public Integer getAmount(){
        return amount;
    }
}
