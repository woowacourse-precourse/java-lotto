package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.*;
import lotto.Judgement;

public class Result {
    private int count;
    private List<Integer> winningNumber;
    private int bonusNumber;
    HashMap<Integer, Integer> winningHistory = new HashMap<Integer, Integer>() {
        {
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
        }
    };
    List<Lotto> purchasedLotteries = new ArrayList<>();

    public Result(){
    }

    public void purchaseLotteries(int count){
        for(int i=0; i<count; i++){
            List<Integer> purchasedLottery = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottery.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(purchasedLottery);
            purchasedLotteries.add(lotto);
        }
    }

    public void printPurchasedLotteries(){
        for (Lotto purchasedLottery:purchasedLotteries){
            System.out.println(purchasedLottery.getNumbers());
        }
    }

    public void calculateWinningHistory(){
        for (Lotto purchasedLottery:purchasedLotteries){
            int sameNumberCount = Judgement.countSameNumber(winningNumber, purchasedLottery.getNumbers());
            int bonusNumberCount = Judgement.countBonusNumber(bonusNumber, purchasedLottery.getNumbers());
            int grade = Judgement.judgeGrade(sameNumberCount, bonusNumberCount);
            if (!(grade==-1)){
                winningHistory.put(grade, winningHistory.get(grade)+1);
            }
        }
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
