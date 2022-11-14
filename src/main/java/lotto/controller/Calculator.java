package lotto.controller;

import lotto.model.Rank;
import lotto.model.ScoreBoard;

import java.util.Map;

public class Calculator {

    public int calculatePrice(ScoreBoard scoreBoard) {
        Map<String, Integer> ranks = scoreBoard.getRankAndScore();
        int priceSum = 0;

        for (String rank : ranks.keySet()) {
            if (ranks.get(rank) > 0) {
                priceSum += ranks.get(rank)* Rank.valueOf(rank).getMatchMoney();
            }
        }
        return priceSum;
    }

    public float calculatePercent(ScoreBoard scoreBoard, int userMoney) {
        return calculatePrice(scoreBoard)/userMoney * 100;
    }


}
