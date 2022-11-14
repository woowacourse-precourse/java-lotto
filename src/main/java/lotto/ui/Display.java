package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Display {

    public void printNewLine() {
        System.out.println();
    }

    public void printRequestPrice() {
        System.out.println(DisplayMessage.REQUEST_PURCHASE_PRICE.message);
    }

    public void printLottoPacks(List<Lotto> lottoPacks) {
        System.out.println(lottoPacks.size() + DisplayMessage.ANNOUNCE_PURCHASED_COUNT.message);
        lottoPacks.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printRequestWinningNumber() {
        System.out.println(DisplayMessage.REQUEST_LOTTO_WINNER_NUMBER.message);
    }

    public void printRequestBonusNumber() {
        System.out.println(DisplayMessage.REQUEST_LOTTO_BONUS_NUMBER.message);
    }

    public void printWinningList(int three, int four, int five, int fiveAndBonus, int six) {
        System.out.println(DisplayMessage.ANNOUNCE_LOTTO_STAT.message);
        System.out.println(DisplayMessage.THREE_NUMBER_MATCH_PREFIX.message + three + "개");
        System.out.println(DisplayMessage.FOUR_NUMBER_MATCH_PREFIX.message + four + "개");
        System.out.println(DisplayMessage.FIVE_NUMBER_MATCH_PREFIX.message + five + "개");
        System.out.println(DisplayMessage.FIVE_AND_BONUS_NUMBER_MATCH_PREFIX.message + fiveAndBonus + "개");
        System.out.println(DisplayMessage.SIX_NUMBER_MATCH_PREFIX.message + six + "개");
    }

    public void printEarningLate(double late) {
        System.out.println(DisplayMessage.LOTTO_EARNINGS_LATE_PREFIX.message + late + "%입니다.");
    }
}
