package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.InputStream;
import java.util.List;

public class PurchaseLotto {
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput=readLine();
        int money =Integer.valueOf(moneyInput);
        return money;
    }
    public static int countLotto(int money){
        if (money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
        }
        return money/1000;
    }
    public List<Integer> lottoNumber(){

        return null;
    }

}
