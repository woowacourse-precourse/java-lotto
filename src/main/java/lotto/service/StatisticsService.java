package lotto.service;

import lotto.domain.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;

public class StatisticsService {

    public Statistics calculateRating(User user, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);

        List<Lotto> lottos = user.getPurchaseLotto();
        for (Lotto lotto : lottos) {
            int catchPoint = matchCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean catchBonusPoint = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            Prize prize = Prize.find(catchPoint, catchBonusPoint);
            prizeMap.put(prize, prizeMap.getOrDefault(prize, 0) + 1);
        }
        return new Statistics(prizeMap);
    }

    public int matchCount(List<Integer> numbers, List<Integer> winnings) {
        int matchCnt = 0;
        for (int nowNum : numbers) {
            if (winnings.contains(nowNum)) {
                matchCnt++;
            }
        }
        return matchCnt;
    }

    public void printTotality(Statistics statistics) {
        StringBuilder printTotalStatus = new StringBuilder(BLANK_BR);
        printTotalStatus.append(PRINT_STATISTICS_MSG).append("\n");
        String[] prizeNames = {"fifth", "fourth", "third", "second", "first"};
        Map<Prize, Integer> prizeMap = statistics.getPrizeMap();

        for (String nowPrize : prizeNames) {
            Prize prize = Prize.valueOf(nowPrize);
            int cnt = prizeMap.getOrDefault(prize, 0);
            printTotalStatus.append(printEachCount(prize, cnt)).append("\n");
        }
        System.out.print(printTotalStatus);
    }

    private String printEachCount(Prize prize, int cnt) {
        //2등과 같이 보너스 볼을 맞추는 경우
        if (prize.isBonusCatchPoint()) {
            return String.format(PRINT_RANK_FORMAT, prize.getCatchPoint(), PRINT_BONUS_MATCH, prize.getMoney(), cnt);
        }
        return String.format(PRINT_RANK_FORMAT, prize.getCatchPoint(), "", prize.getMoney(), cnt);
    }

    public void printProfit(Statistics statistic, User user) {
        double profit = statistic.getTotal() / user.getPurchaseMoney() * 100;
        System.out.printf(PRINT_PROFIT_FORMAT + "\n", profit);
    }
}
