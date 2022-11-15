package lotto.controller;

import lotto.model.Rank;
import lotto.model.ScoreBoard;
import lotto.view.OutputView;

import java.util.Map;

public class Calculator {
    public final static int RANK_COUNT = 0;
    public int calculatePrice(ScoreBoard scoreBoard) {
        Map<String, Integer> ranks = scoreBoard.getRankAndScore();
        int priceSum = 0;

        for (String rank : ranks.keySet()) {
            if (ranks.get(rank) > RANK_COUNT) {
                priceSum += ranks.get(rank)* Rank.valueOf(rank).getMatchMoney();
            }
        }
        return priceSum;
    }

    public void calculatePercent(ScoreBoard scoreBoard, int userMoney) {
        double percent;
        percent = calculatePrice(scoreBoard)/(double)userMoney*100;

        OutputView.printPercentage(percent);
    }


}
