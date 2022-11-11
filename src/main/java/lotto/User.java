package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    String money;
    String lottoQuantity;
    void inputMoney(){
        this.money= Console.readLine();
        validate();
    }

    private void validate(){
        if(checkDivisibleByThousand(money.substring(money.length()-3))){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위이어야 합니다.");
        }
    }

    private boolean checkDivisibleByThousand(String lastThreeDigit){
        if(!lastThreeDigit.equals("000")){
            return true;
        }
        return false;
    }

    void setLottoQuantity(){
        this.lottoQuantity=calculateQuantity();
    }

    private String calculateQuantity(){
        return money.substring(0,money.length()-3);
    }
}
