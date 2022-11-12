package lotto.domain;

import java.util.Arrays;

public class Result {

    private Rank[] ranks;
    private float winningAmount;

    public Result(Rank[] ranks) {
        this.ranks = ranks;
    }

    public void initWinningAmount(int purchase){
        Arrays.stream(ranks)
                .forEach(rank -> winningAmount += rank.getPrize() * rank.getCount());
        winningAmount = (winningAmount / purchase) * 100;
    }
    public float getWinningAmount() {
        return winningAmount;
    }
}
