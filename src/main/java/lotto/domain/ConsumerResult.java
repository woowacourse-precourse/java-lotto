package lotto.domain;

import java.util.List;

public class ConsumerResult {
    public void myLotto(){
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        int money = purchaseLotto.inputMoney();
        for (int count=0; count < purchaseLotto.countLotto(money); count++){
            System.out.println(purchaseLotto.myLottoNumber());
        }
    }
    public float profit(){
        return 0;
    }

    public List<Integer> winLotto(){
        return null;
    }
}
