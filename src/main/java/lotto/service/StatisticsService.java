package lotto.service;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;

public class StatisticsService {
    private static final DecimalFormat formatter = new DecimalFormat("###,###.##");

    public Statistics calc(User user, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);

        List<Lotto> lottos = user.getPurchaseLotto();
        for (Lotto lotto : lottos) {
            int matchCount = matchCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusNum = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            Prize prize = Prize.find(matchCount, bonusNum);
            prizeMap.put(prize, prizeMap.getOrDefault(prize, 0) + 1);
        }
        return new Statistics(prizeMap);
    }


    private int matchCount(List<Integer> numbers, List<Integer> winnings) {
        int matchCnt = 0;
        for (int nowNum : numbers) {
            if (winnings.contains(nowNum)) matchCnt++;
        }
        return matchCnt;
    }

    public void printTotality(Statistics statistics) {
        StringBuilder printTotalStatus = new StringBuilder(BLANK_BR);
        printTotalStatus.append(PRINT_STATISTICS_MSG).append("\n");
        String[] value = {"fifth", "fourth", "third", "second", "first"};
        Map<Prize, Integer> prizeMap = statistics.getPrizeMap();

        for (String nowValue : value) {
            Prize prize = Prize.valueOf(nowValue);
            int cnt = prizeMap.getOrDefault(prize, 0);
            printTotalStatus.append(printEachCount(prize, cnt)).append("\n");
        }
        System.out.print(printTotalStatus);

    }

    private String printEachCount(Prize prize, int cnt) {
        String eachPrint = prize.getCatchPoint() + "개 일치, ";

        if (prize.isBonusCatchPoint())
            eachPrint += "보너스 볼 일치 ";

        eachPrint += "(" + formatter.format(prize.getMoney()) + ") - " + cnt + "개";

        return eachPrint;
    }

    public void printProfit(Statistics statistic, User user) {
        double profit = statistic.getTotal() / user.getPurchaseMoney() * 100;
        System.out.printf(PROFIT_MSG + "\n", formatter.format(profit));
    }
}
