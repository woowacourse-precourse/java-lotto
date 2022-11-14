package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class User {
    private int PurchaseAmount;
    private List<Lotto> LotteryNumbers;

    public void inputPurchaseAmount(String input){
        validate(input);
        this.PurchaseAmount = Integer.parseInt(input);
    }

    private boolean validate(String input){
        char c;
        for(int i=0; i<input.length(); i++){
            c = input.charAt(i);
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
