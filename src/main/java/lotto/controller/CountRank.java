package lotto.controller;

import lotto.model.*;
import lotto.view.OutputView;

import java.util.List;

public class CountRank {
    ScoreAndRank scoreAndRank;
    ScoreBoard scoreBoard;
    Calculator calculator;

    public CountRank() {
        scoreAndRank = new ScoreAndRank();
        scoreBoard = new ScoreBoard();
        calculator = new Calculator();
    }

    public void doMatchNumber(UserLottoNum userLottoNum, Lotto targetLottoNum, int bonusNum) {
        List<Integer> targetNumber = targetLottoNum.getLotto();
        List<Lotto> userLottoNumbers = userLottoNum.getUserLottoNumbers();

        for (Lotto userLottoNumber : userLottoNumbers) {
            int count = countMatchNumber(userLottoNumber, targetNumber);
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
