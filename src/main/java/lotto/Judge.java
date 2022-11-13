package lotto;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    List<Integer> rankCount = new ArrayList<>();

    public void setRankCount(List<Lotto> lotteries, List<Integer> winningNumbers) {

        for (int i = 0; i < 6; i++) {
            rankCount.add(0);
        }

        for (Lotto lottery : lotteries) {
            int index = lottery.confirmNumbers(winningNumbers);
            rankCount.set(index, rankCount.get(index) + 1);
        }

    }

//    public int countPrizeMoney(){
//
//    }
//
//    public  double countEarningsRate(){
//
//    }
}
