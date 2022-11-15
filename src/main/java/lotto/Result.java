package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import static lotto.Prize.*;

public class Result {


    private int count;
    private List<Integer> winningNumber;
    private int bonusNumber;
    HashMap<Prize, Integer> winningStatistics = new HashMap() {
        {
            put(First, 0);
            put(Second, 0);
            put(Third, 0);
            put(Fourth, 0);
            put(Fifth, 0);
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

    public void calculateWinningStatistics(){
        for (Lotto purchasedLottery:purchasedLotteries){
            int sameNumberCount = Judgement.countSameNumber(winningNumber, purchasedLottery.getNumbers());
            int bonusNumberCount = Judgement.countBonusNumber(bonusNumber, purchasedLottery.getNumbers());
            Prize prize = Judgement.judgeGrade(sameNumberCount, bonusNumberCount);
            if (!(prize==Invalid)){
                winningStatistics.put(prize, winningStatistics.get(prize)+1);
            }
        }
    }

    public void printWinningStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%d)원 - %d개\n", Fifth.getPrizeMoney(), winningStatistics.get(Fifth));
        System.out.printf("4개 일치 (%d)원 - %d개\n", Fourth.getPrizeMoney(),winningStatistics.get(Fourth));
        System.out.printf("5개 일치 (%d)원 - %d개\n", Third.getPrizeMoney(), winningStatistics.get(Third));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d)원 - %d개\n", Second.getPrizeMoney(), winningStatistics.get(Second));
        System.out.printf("6개 일치 (%d)원 - %d개\n", First.getPrizeMoney(), winningStatistics.get(First));
        System.out.printf("총 수익률은 %.1f%%입니다.", Judgement.calculateEarningRate(count*1000, calculateTotalPrizeMoney()));
    }

    public int calculateTotalPrizeMoney(){
        int total = 0;
        total += Fifth.getPrizeMoney() * winningStatistics.get(Fifth);
        total += Fourth.getPrizeMoney() * winningStatistics.get(Fourth);
        total += Third.getPrizeMoney() * winningStatistics.get(Third);
        total += Second.getPrizeMoney() * winningStatistics.get(Second);
        total += First.getPrizeMoney() * winningStatistics.get(First);
        return total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
