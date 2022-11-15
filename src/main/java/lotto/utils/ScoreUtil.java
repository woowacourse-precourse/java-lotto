package lotto.utils;

import lotto.domain.ScoreInfo;

import java.util.List;

import static lotto.domain.ScoreInfo.ELSE;
import static lotto.domain.ScoreInfo.FIVE;
import static lotto.view.controller.ConsoleMessage.PRINT_BACK_TOTAL_RETURN_RATE;
import static lotto.view.controller.ConsoleMessage.PRINT_FRONT_TOTAL_RETURN_RATE;

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
        if (bonusCount.equals(1) && scoreInfo.getCorrectCount().equals(5)) {
            return FIVE;
        }
        return scoreInfo;
    }
    public static String calRateOfReturnMessage(List<Integer> scoreBoard) {
        Float totalReturn = 0F;
        Integer totalBuyMoney = scoreBoard.stream().mapToInt(Integer::intValue).sum() * 1000;
        for (ScoreInfo scoreInfo : ScoreInfo.values()) {
            totalReturn += (scoreInfo.getWinnerMoney() * scoreBoard.get(scoreInfo.getRank()));
        }
        return PRINT_FRONT_TOTAL_RETURN_RATE.getMessage()
                + String.format("%.1f", (totalReturn / totalBuyMoney) * 100)
                + PRINT_BACK_TOTAL_RETURN_RATE.getMessage();
    }
}
