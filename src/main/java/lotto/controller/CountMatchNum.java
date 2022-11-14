package lotto.controller;

import lotto.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMatchNum {

    public final static int SCORE_BOARD = 5;
    ScoreAndRank scoreAndRank;
    ScoreBoard scoreBoard;

    public CountMatchNum() {
        scoreAndRank = new ScoreAndRank();
        scoreBoard = new ScoreBoard();
    }

    public void DoMatchNumber(UserLottoNum userLottoNum, Lotto targetLottoNum) {
        int count;

        for (Lotto userLottoNumber : userLottoNum.getUserLottoNumbers()) {
            count = countMatchNumber(userLottoNumber, targetLottoNum);

            scoreBoard.plusScore(scoreAndRank.scoreRank.get(count));
        }
    }

    public int countMatchNumber(Lotto userLottoNumber, Lotto targetLottoNum) {
        int count = 0;
        List<Integer> targetNumber = targetLottoNum.getLotto();

        for (Integer lotto : userLottoNumber.getLotto()) {
            if (targetNumber.contains(lotto)) {
                count++;
            }
        }
        System.out.println("count = " + count);
        return count;
    }
}
