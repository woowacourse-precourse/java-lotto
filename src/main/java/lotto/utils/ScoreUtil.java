package lotto.utils;

import lotto.domain.ScoreInfo;

import static lotto.domain.ScoreInfo.ELSE;
import static lotto.domain.ScoreInfo.FIVE;

public class ScoreUtil {

    private ScoreUtil() {
    }

    public static ScoreInfo findRankByCorrectLottoCount(Integer correctCount, Integer bonusCount) {

        for (ScoreInfo scoreInfo : ScoreInfo.values()) {
            if (correctCount.equals(scoreInfo.getCorrectCount())) {
                return isSecondOrElse(bonusCount, scoreInfo);
            }
        }
        return ELSE;
    }

    private static ScoreInfo isSecondOrElse(Integer bonusCount, ScoreInfo scoreInfo) {
        if (bonusCount.equals(1)) {
            return FIVE;
        }
        return scoreInfo;
    }

}
