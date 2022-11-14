package View;

import enumCollections.GuideMessage;
import enumCollections.ResultStatistics;
import lotto.Lotto;

import java.util.ArrayList;
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
        System.out.printf("수익률은 %f 입니다.", yield);
    }

    public static List<String> getCompleteStatistics(int[] resultStatistics) {
        List<String> statistics = new ArrayList<>();
        for (ResultStatistics message : ResultStatistics.values()) {
        }
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void getGuideMessage(GuideMessage message) {
        System.out.println(message);
    }

    public static void getGuideMessage(GuideMessage message, int value) {
        System.out.println(Integer.toString(value) + message);
    }
}
