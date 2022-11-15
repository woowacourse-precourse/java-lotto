package lotto;

import java.util.HashMap;

public class Caculator {

    private final int money;

    private final int LOTTO_PRICE = 1000;

    public Caculator(int money) {
        this.money = money;
    }

    private int caculatePaper(long money) {
        int paper = (int)money / LOTTO_PRICE;
        return paper;
    }

    private long caculateTotalPrize(HashMap<String, Integer> winnigCount, int money) {
        long prize = 0;
        prize += winnigCount.get("FIFTH") * Winning.FIFTH.getRankNumber()
                + winnigCount.get("FOURTH") * Winning.FOURTH.getRankNumber()
                + winnigCount.get("THIRD") * Winning.THIRD.getRankNumber()
                + winnigCount.get("SECOND") * Winning.SECOND.getRankNumber()
                + winnigCount.get("FIRST") * Winning.FIRST.getRankNumber();
        return prize;
    }

    private double caculateReturnOfRate(HashMap<String, Integer> winnigCount, int money) {
        long prize = caculateTotalPrize(winnigCount, money);
        double rate = (double) prize / money *100;

        return rate;
    }

}
