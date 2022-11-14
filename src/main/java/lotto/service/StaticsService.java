package lotto.service;

import lotto.domain.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class StaticsService {

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
        String[] value = {"fifth", "fourth", "third", "second", "first"};
        Map<Prize, Integer> prizeMap = statistics.getPrizeMap();

        System.out.println(prizeMap.keySet());
        System.out.println(prizeMap.values());

        for (String nowValue : value) {
            int cnt = prizeMap.getOrDefault(Prize.valueOf(nowValue), 0);
            System.out.println(Prize.valueOf(nowValue) + " " + cnt);
        }

    }
}
