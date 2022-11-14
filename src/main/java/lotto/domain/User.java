package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class User {
    private int purchaseAmount;
    private List<Lotto> lotteryNumbers;

    public void inputPurchaseAmount(String input){
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }

    public List<Lotto> getLotteryNumbers(){
        return lotteryNumbers;
    }

    private void validate(String input) throws RuntimeException{
        char c;

        for(int i=0; i<input.length(); i++){
            c = input.charAt(i);
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(LottoException.NOT_DISIT.getErrorMessage());
        }

        int intInput = Integer.parseInt(input);

        if(intInput%1000 !=0)
            throw new IllegalArgumentException(LottoException.NOT_EFFECTIVE_UNIT.getErrorMessage());
    }
}
