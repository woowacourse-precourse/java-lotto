package lotto.utils;

import lotto.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

import static lotto.LottoRank.*;

public class Statistics {

    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int fourth = 0;
    private static int fifth = 0;

    public Statistics(List<Lotto> lottos, Result result) {
        for(Lotto lotto : lottos) {
            LottoRank rank = getRank(lotto, result);
            if(rank != null) {
                count(rank);
            }
        }
    }

    public static int getFirst() {
        return first;
    }

    public static int getSecond() {
        return second;
    }

    public static int getThird() {
        return third;
    }

    public static int getFourth() {
        return fourth;
    }

    public static int getFifth() {
        return fifth;
    }

    private void count(LottoRank rank) {
        if(rank.equals(FIRST)) {
            first++;
        }
        if(rank.equals(SECOND)) {
            second++;
        }
        if(rank.equals(THIRD)) {
            third++;
        }
        if(rank.equals(FOURTH)) {
            fourth++;
        }
        if(rank.equals(FIFTH)) {
            fifth++;
        }
    }

    private LottoRank getRank(Lotto lotto, Result result) {
        int matchingCount = 0, bonus = 0;

        for(int number : lotto.getNumbers()) {
            if(result.getNumbers().contains(number)) {
                matchingCount++;
            }
            if(result.getBonus() == number) {
                bonus++;
            }
        }
        return getLottoRank(matchingCount, bonus);
    }

    private LottoRank getLottoRank(int matchingCount, int bonus) {
        if(matchingCount == 6) {
            return FIRST;
        }
        if(matchingCount == 5 && bonus == 1) {
            return SECOND;
        }
        if(matchingCount == 5) {
            return THIRD;
        }
        if(matchingCount == 4) {
            return FOURTH;
        }
        if(matchingCount == 3) {
            return FIFTH;
        }
        return null;
    }

    public static double calcRate(int cost) {
        return Math.round((float) calculatePrize() / cost * 1000) / 10.0;
    }

    private static long calculatePrize() {
        return (long) first * FIRST.getPrize()
                + (long) second * SECOND.getPrize()
                + (long) third * THIRD.getPrize()
                + (long) fourth * FOURTH.getPrize()
                + (long) fifth * FIFTH.getPrize();
    }
}
