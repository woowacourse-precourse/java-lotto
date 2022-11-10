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

    public int myIncome(int lottoCount, int bonusCount){
        int income = 0;
        if(lottoCount==3){
            income+=5000;
        }if(lottoCount==4){
            income+=50000;
        }if(lottoCount==5){
            income+=1500000;
        }if(lottoCount==5 && bonusCount==1){
            income+=30000000;
        }if(lottoCount==6){
            income+=2000000000;
        }
        return income;
    }

    public void winLotto(){
        
    }
}
