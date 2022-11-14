package View;

import enumCollections.GuideMessage;
import enumCollections.RankNumber;
import enumCollections.ResultStatistics;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Output {
    public static void getPurchaseAmount() {
        getGuideMessage(GuideMessage.PURCHASE_INPUT);
    }

    public static void getNumberOfPurchase(int number) {
        getGuideMessage(GuideMessage.NUMBER_OF_PURCHASE, number);
    }

    public static void getWinningNumbers() {
        getGuideMessage(GuideMessage.WINNING_NUMBERS_INPUT);
    }

    public static void getBonusNumber() {
        getGuideMessage(GuideMessage.BONUS_NUMBER_INPUT);
    }

    public static void yield(float yield) {
        System.out.printf(ResultStatistics.getMessage(ResultStatistics.YIELD), yield);
    }

    public static void showResultStatistics(EnumMap<RankNumber, Integer> resultStatistics) {
        getGuideMessage(ResultStatistics.GUIDE_MESSAGE);
        getGuideMessage(ResultStatistics.LINE);
        getCompleteStatistics(resultStatistics);
    }

    public static void getCompleteStatistics(EnumMap<RankNumber, Integer> resultStatistics) {
        for (ResultStatistics rank : ResultStatistics.values()) {
            if (rank.equals(ResultStatistics.YIELD)) {
                break;
            }
            System.out.printf(
                    ResultStatistics.getMessage(rank),
                    resultStatistics.get(RankNumber.valueOf(rank.toString()))
            );
        }
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLottoNumbers();
        }
    }

    public static void getGuideMessage(Enum message) {
        System.out.println(message);
    }

    public static void getGuideMessage(GuideMessage message, int value) {
        System.out.println(Integer.toString(value) + message);
    }
}
