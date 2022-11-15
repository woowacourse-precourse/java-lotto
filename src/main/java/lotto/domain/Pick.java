package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class Pick {
    private final List<Integer> answer;
    private final int bonus;
    private List<Integer> scores;

    public Pick(List<Integer> answer, int bonus) {
        this.answer = answer;
        this.bonus = bonus;
        this.scores = initScores();
    }

    private List<Integer> initScores() {
        List<Integer> scores = new ArrayList<>();
        int lowestRank = 5;

        for (int rank = 0; rank <= lowestRank; rank++) {
            scores.add(0);
        }

        return scores;
    }

    public void drawLottoes(List<Lotto> lottoes) {
        int rank;

        for (Lotto lotto : lottoes) {
            rank = lotto.draw(answer, bonus);
            scores.set(rank, scores.get(rank) + 1);
        }
    }

    public List<Integer> getScores() {
        return scores;
    }

    public double getRateOfReturn(int money) {
        int winningMoney = getWinningMoney();
        double rateOfReturn = (double)winningMoney / (double)money * 100.0;

        return Math.round(rateOfReturn * 10) / 10.0;
    }

    private int getWinningMoney() {
        int winningMoney = 0;
        int count;

        for (int rank = 1; rank <= 5; rank++) {
            count = scores.get(rank);
            winningMoney += getWinningMoneyWithCount(rank, count);
        }

        return winningMoney;
    }

    private int getWinningMoneyWithCount(int rank, int count) {
        if (rank == 1) {
            return 2_000_000_000 * count;
        }
        if (rank == 2) {
            return 30_000_000 * count;
        }
        if (rank == 3) {
            return 1_500_000 * count;
        }
        if (rank == 4) {
            return 50_000 * count;
        }
        if (rank == 5) {
            return 5_000 * count;
        }
        return 0;
    }
}
