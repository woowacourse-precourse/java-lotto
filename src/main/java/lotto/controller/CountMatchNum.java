package lotto.controller;

import lotto.model.*;
import lotto.view.OutputView;

import java.util.List;

public class CountMatchNum {
    ScoreAndRank scoreAndRank;
    ScoreBoard scoreBoard;

    public CountMatchNum() {
        scoreAndRank = new ScoreAndRank();
        scoreBoard = new ScoreBoard();
    }

    public void doMatchNumber(UserLottoNum userLottoNum, Lotto targetLottoNum, int bonusNum) {
        int count;
        List<Integer> targetNumber = targetLottoNum.getLotto();
        List<Lotto> userLottoNumbers = userLottoNum.getUserLottoNumbers();

        for (Lotto userLottoNumber : userLottoNumbers) {
            count = countMatchNumber(userLottoNumber, targetNumber);
            if(count == 5 && targetNumber.contains(bonusNum)) {
                scoreBoard.plusScore(scoreAndRank.getScoreRank().get(7));
                continue;
            }
            if(count >=3 ) {
                scoreBoard.plusScore(scoreAndRank.getScoreRank().get(count));
            }
        }
        OutputView.printRank(scoreBoard);
    }

    public int countMatchNumber(Lotto userLottoNumber, List<Integer> targetNumber) {
        int count = 0;

        for (Integer lotto : userLottoNumber.getLotto()) {
            if (targetNumber.contains(lotto)) {
                count++;
            }
        }
        return count;
    }
}
