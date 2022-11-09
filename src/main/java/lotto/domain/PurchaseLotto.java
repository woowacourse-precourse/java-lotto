package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class PurchaseLotto {
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput=readLine();
        int money =Integer.valueOf(moneyInput);
        return money;
    }
    public int countLotto(){
        return 0;
    }
    public List<Integer> lottoNumber(){
        return null;
    }

}
