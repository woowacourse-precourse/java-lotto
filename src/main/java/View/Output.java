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
        printFormatGuideMessage(GuideMessage.NUMBER_OF_PURCHASE, number);
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
        printResultStatistics(ResultStatistics.GUIDE_MESSAGE);
        printResultStatistics(ResultStatistics.LINE);
        getCompleteStatistics(resultStatistics);
    }

    public static void getCompleteStatistics(EnumMap<RankNumber, Integer> resultStatistics) {
        for (ResultStatistics rank : ResultStatistics.values()) {
            if (rank.equals(ResultStatistics.YIELD)) {
                break;
            }
            printFormatResultStatistics(
                    rank,
                    resultStatistics.get(ResultStatistics.getRankNumber(rank))
            );
        }
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLottoNumbers();
        }
    }

    public static void getGuideMessage(GuideMessage situation) {
        System.out.println(GuideMessage.getMessage(situation));
    }

    public static void printFormatGuideMessage(GuideMessage situation, int value) {
        System.out.printf(GuideMessage.getMessage(situation).concat("\n"), value);
    }

    public static void printResultStatistics(ResultStatistics rank) {
        System.out.println(ResultStatistics.getMessage(rank));
    }

    public static void printFormatResultStatistics(ResultStatistics rank, int value) {
        System.out.printf(ResultStatistics.getMessage(rank).concat("\n"), value);
    }

}
