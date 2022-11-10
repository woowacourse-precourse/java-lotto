package lotto.Message;

import java.util.List;

public class NormalMessage {
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String BASE_RESULT_MESSAGE = "당첨통계" + "\n" + "---";

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printBuyMessage(Integer number) {
        System.out.println();
        System.out.println(number.toString() + BUY_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printResultMessage(List<Integer> lottoResult, double yield) {
        System.out.println();
        System.out.println(BASE_RESULT_MESSAGE);

        for (int place = 6; place > 0; place--) {
        }

    }
}
