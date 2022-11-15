package lotto.controller;

import lotto.model.RankOfLotto;

import java.util.List;

public class LottoCalculator {
    public static int rankOfThisLotto(List<Integer> myLotto, List<Integer> winningLotto, int bonusNumber) {
        int count = 0;
        for (int number : myLotto) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }

        if (count == 3) {
            return RankOfLotto.FIFTHPRIZE.ordinal();
        }
        if (count == 4) {
            return RankOfLotto.FOURTHPRIZE.ordinal();
        }
        if (count == 5) {
            if (!myLotto.contains(bonusNumber)) {
                return RankOfLotto.THIRDPRIZE.ordinal();
            }
            return RankOfLotto.SECONDPRIZE.ordinal();
        }
        if (count == 6) {
            return RankOfLotto.FIRSTPRIZE.ordinal();
        }
        return RankOfLotto.NOTHING.ordinal();
    }

    public static float calculateYield(int cost, int[] rankOfMyLotto) {
        float prizeMoney = 0;
        int index = 0;
        RankOfLotto[] rankOfLotto = RankOfLotto.values();
        for (int count : rankOfMyLotto) {
            prizeMoney += count * rankOfLotto[index].getMoney();
            index++;
        }
        return (prizeMoney / cost) * 100;
    }
}
