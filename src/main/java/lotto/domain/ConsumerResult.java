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
    public int compareLotto(List<Integer> myLotto, List<Integer> lottoNumber){
        int count=0;
        for (int index=0; index< lottoNumber.size();index++){
            if (lottoNumber.contains(myLotto.get(index))){
                count++;
            }
        }
        return 0;
    }

    public int compareBonus(List<Integer> myLotto, int bonusNumber){
        if(myLotto.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }

    public float profit(){
        return 0;
    }

    public List<Integer> winLotto(){
        return null;
    }
}
