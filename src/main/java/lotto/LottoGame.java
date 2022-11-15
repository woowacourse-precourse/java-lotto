package lotto;


import static lotto.NumberType.*;
import static lotto.Output.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class LottoGame {

    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private ArrayList<Integer> WinningNumber = new ArrayList<>();
    private int bonusNumber;

    public void createLotteGame(String PurchaseMoney) {
        int number = Integer.parseInt(PurchaseMoney)/1000;
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(
                Randoms.pickUniqueNumbersInRange(NUMBER_START.getNumber(), NUMBER_END.getNumber(),
                    NUMBER_COUNT.getNumber()));
            lottos.add(lotto);
        }
        printPurchaseCount(number);
    }

    public ArrayList<Lotto> getLottoGame() {
        return this.lottos;
    }
    public void printLottos() {
        for (int i = 0 ; i< lottos.size() ; i++){
            System.out.println(lottos.get(i));
        }
     }

     public void setWinningNumber(String WinningNum) {
         String WinningNumbers[] = WinningNum.split(",");
         for (String winningNum : WinningNumbers) {
             this.WinningNumber.add(Integer.parseInt(winningNum));
         }
     }

     public  void setBonusNumber(String BonusNumber){
        this.bonusNumber = Integer.parseInt(BonusNumber);
     }

     public void compare(){
        for (int i = 0 ; i< lottos.size() ; i++){
            lottos.get(i).compare();
        }
     }


}
