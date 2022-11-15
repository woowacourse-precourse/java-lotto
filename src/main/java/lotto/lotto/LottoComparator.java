package lotto.lotto;

import java.util.List;

public class LottoComparator {

    public static int getMatchedNumbers(List<Integer> winner, List<Integer> user) {
        int counter = 0;
        for(int i = 0 ; i < winner.size() - 1; i++) {
            for (int j = 0; j < user.size(); j++) {
                if (winner.get(i).equals(user.get(j)))
                    counter += 1;
            }
        }

        return (counter);
    }

    public static boolean isBonusMatched(List<Integer> winner, List<Integer> user) {
        for(Integer userBall : user) {
            if (userBall.equals(winner.get(winner.size() - 1)))
                return true;
        }
        return false;
    }

    public void printStatistics(Lotto winn, List<Lotto> lottos) {
        LottoPrinter printer = new LottoPrinter();
        for(Lotto lotto: lottos) {
            int matchedBalls = LottoComparator.getMatchedNumbers(winn.getNumbers(), lotto.getNumbers());
            boolean bonusMatched = LottoComparator.isBonusMatched(winn.getNumbers(), lotto.getNumbers());

            printer.addResult(matchedBalls, bonusMatched);
        }

        printer.printLottoResult();
    }

    public Double getProfitRate(Lotto winn, List<Lotto> lottos) {
        Double inputMoney = (double) (lottos.size() * LottoEnums.LOTTO_PRICE.value());
        Double earnedMoney = 0.0;
        LottoPrinter printer = new LottoPrinter();

        for(Lotto lotto: lottos) {
            int matchedBalls = LottoComparator.getMatchedNumbers(winn.getNumbers(), lotto.getNumbers());
            boolean bonusMatched = LottoComparator.isBonusMatched(winn.getNumbers(), lotto.getNumbers());

            printer.addResult(matchedBalls, bonusMatched);
        }

        int[] ballMatched = printer.getMatched();
        return (getProfit(ballMatched) / inputMoney) * 100;
    }

    private int getProfit(int[] matched) {
        int earnedMoney = 0;
        if (matched[0] != 0) earnedMoney += LottoEnums.LOTTO_PRIZE_EQ_3.value() * matched[0];
        if (matched[1] != 0) earnedMoney += LottoEnums.LOTTO_PRIZE_EQ_4.value() * matched[1];
        if (matched[2] != 0) earnedMoney += LottoEnums.LOTTO_PRIZE_EQ_5.value() * matched[2];
        if (matched[3] != 0) earnedMoney += LottoEnums.LOTTO_PRIZE_BONUS.value() * matched[3];
        if (matched[4] != 0) earnedMoney += LottoEnums.LOTTO_PRIZE_EQ_6.value() * matched[4];
        return earnedMoney;
    }
}
