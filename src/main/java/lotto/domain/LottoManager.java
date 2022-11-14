package lotto.domain;

public class LottoManager {

    public int countLotto(String inputMoney){
        int money = stringToInteger(inputMoney);
        hasRestError(money);
        MinimumAmountError(money);
        return money / 1000;
    }
    public int stringToInteger(String money) throws IllegalArgumentException{
        return Integer.parseInt(money);
    }

    public void hasRestError(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public void MinimumAmountError(int money){
        if(money < 1000){
            throw new IllegalArgumentException();
        }
    }


}
