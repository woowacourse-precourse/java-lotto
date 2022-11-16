package lotto.view;

import lotto.domain.Lotto;
import lotto.type.TextType;

import java.util.List;

public class OutputView {

    public static void showLottoCount(int count) {
        System.out.println("\n" + count + TextType.LOTTO_COUNT_MESSAGE.getText());
    }

    public static void showLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }

    public static void showWinHistory(List<Integer> winHistory) {
        System.out.println(TextType.TITLE_WIN_DETAILS.getText());
        System.out.printf(TextType.THREE_MATCH_MESSAGE_FORMAT.getText(),winHistory.get(0));
        System.out.printf(TextType.FOUR_MATCH_MESSAGE_FORMAT.getText(), winHistory.get(1));
        System.out.printf(TextType.FIVE_MATCH_MESSAGE_FORMAT.getText(), winHistory.get(2));
        System.out.printf(TextType.SIX_WITH_BONUS_MATCH_MESSAGE_FORMAT.getText(), winHistory.get(3));
        System.out.printf(TextType.SIX_MATCH_MESSAGE_FORMAT.getText(), winHistory.get(4));
    }

    public static void showYield(double yield) {
        System.out.printf(TextType.YIELD_MESSAGE_FORMAT.getText(),yield);
    }
}
