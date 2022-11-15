package lotto.domain;

import static lotto.constant.OutputMessage.DIVISION;
import static lotto.constant.OutputMessage.WINNING_STATISTICS;

import java.util.List;

public class MatchLotto {

    private static int rank1 = 0;
    private static int rank2 = 0;
    private static int rank3 = 0;
    private static int rank4 = 0;
    private static int rank5 = 0;
    private static double revenue = 0;

    public void matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int inputAmount) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION);

        for (Lotto lotto : lottos) {
            int winningRank = getRank(lotto, winningNumbers, bonusNumber);
            calculateResult(winningRank);
        }

        double yield = revenue / (double) inputAmount * 100;
//        printResult(yield);
    }

    public int getRank(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean matchBonus = false;

        for (int i = 0; i < 6; i++) {
            if(winningNumber.contains(lotto.getNumber(i))) {
                count++;
            }
            if(bonusNumber == lotto.getNumber(i)) {
                matchBonus = true;
            }
        }
        if (count > 2) {
            return getRankDetail(count, matchBonus);
        }
        return 0;
    }

    public int getRankDetail(int count, boolean matchBonus) {
        if (count == 6) {
            return 1;
        }
        if (count == 5) {
            if (matchBonus) {
                return 2;
            }
            return 3;
        }
        if (count == 4) {
            return 4;
        }
        return 5;
    }

    public void calculateResult(int winningRank) {
        //5등이내에 들지 않는 경우
        if (winningRank == 0) {
            return;
        }
        if (winningRank == 1) {
            rank1++;
            revenue += 2000000000;
        }
        if (winningRank == 2) {
            rank2++;
            revenue += 30000000;
        }
        if (winningRank == 3) {
            rank3++;
            revenue += 1500000;
        }
        if (winningRank == 4) {
            rank4++;
            revenue += 50000;
        }
        if (winningRank == 5) {
            rank5++;
            revenue += 5000;
        }
    }

}
