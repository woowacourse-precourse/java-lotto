package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class User {
    String money;
    String lottoQuantity;
    List<Lotto> lottos;

    User(){
        this.lottos=new ArrayList<Lotto>();
    }

    void inputMoney(){
        this.money= Console.readLine();
        validate();
    }

    private void validate(){
        if(checkDivisibleByThousand(money.substring(money.length()-3))){
            throw new IllegalArgumentException("구입금액은 1000원 단위이어야 합니다.");
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

    void printLottoQunantity(){
        System.out.println();
        System.out.println(this.lottoQuantity+"개를 구매했습니다.");
    }
}
