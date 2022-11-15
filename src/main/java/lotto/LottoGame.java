package lotto;


import static lotto.NumberType.*;
import static lotto.Output.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class LottoGame {

    private final ArrayList<Lotto> lottos;
    private final ArrayList<Integer>  WinningNumber;
    private int bonusNumber;
    private Statistic statistic;
    private int purchasedMoney;

    LottoGame(){
        lottos = new ArrayList<>();
        WinningNumber = new ArrayList<>();
    }
    public void setPurchasedMoney(String PurchaseMoney) {
        this.purchasedMoney = Integer.parseInt(PurchaseMoney);
    }
    public void createLotteGame(String PurchaseMoney) {
        setPurchasedMoney(PurchaseMoney);
        for (int i = 0; i < this.purchasedMoney/1000; i++) {
            Lotto lotto = new Lotto(
                Randoms.pickUniqueNumbersInRange(NUMBER_START.getNumber(), NUMBER_END.getNumber(),
                    NUMBER_COUNT.getNumber()));
            lottos.add(lotto);
        }
        printPurchaseCount(this.purchasedMoney/1000);
    }

    public void printLottos() {
        for (int i = 0 ; i< lottos.size() ; i++){
            System.out.println(lottos.get(i));
        }
     }

     public void setWinningNumber(String WinningNum) {
         String winningNumbers[] = WinningNum.split(",");
         for (String winningNum : winningNumbers) {
             this.WinningNumber.add(Integer.parseInt(winningNum));
         }
     }

     public  void setBonusNumber(String BonusNumber){
        this.bonusNumber = Integer.parseInt(BonusNumber);
     }

     public void compare(){
         statistic = new Statistic();
         statistic.score(WinningNumber,bonusNumber,lottos);
     }
     public void printStatistic() {
        Statistic.printMatchedCount();
        printProfit(Statistic.getProfit(purchasedMoney));
     }
}
