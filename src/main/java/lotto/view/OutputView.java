package lotto.view;

import lotto.domain.WinningType;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    private static final String LINE_FEED = "\n";
    private static final int pourcentage = 100;

    private static final String READ_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String PRINT_PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";
    private final static String PRINT_RESULT_EQUAL_MESSAGE = "개 일치";
    private final static String PRINT_RESULT_BONUS_MESSAGE = ", 보너스 볼 일치";
    private final static String PRINT_RESULT_WINNING_START_MESSAGE = " (";
    private final static String PRINT_RESULT_WINNING_END_MESSAGE = "원) - ";
    private final static String PRINT_RESULT_NUM_MESSAGE = "개";
    private static final String PRINT_EARNING_START_MESSAGE = "총 수익률은 ";
    private static final String PRINT_EARNING_END_MESSAGE = "%입니다.";

    public static String getReadInputMessage() {
        return READ_INPUT_MESSAGE;
    }

    public static String getReadWinningNumbersMessage() {
        return LINE_FEED + READ_WINNING_NUMBERS_MESSAGE;
    }

    public static String getReadBonusNumberMessage() {
        return LINE_FEED + READ_BONUS_NUMBER_MESSAGE;
    }

    public static void printPurchaseNum(int number) {
        System.out.println(LINE_FEED + number + PRINT_PURCHASE_NUM_MESSAGE);
    }

    public static void printEachWinningResult(WinningType type, Map<WinningType, Integer> winningResults) {

        if (type == WinningType.NONE) return;

        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        System.out.print(type.getEqualCount() + PRINT_RESULT_EQUAL_MESSAGE);

        if (type.getWithBonus())
            System.out.print(PRINT_RESULT_BONUS_MESSAGE);

        System.out.print(PRINT_RESULT_WINNING_START_MESSAGE);
        System.out.print(decimalFormat.format(type.getWinnings()));
        System.out.print(PRINT_RESULT_WINNING_END_MESSAGE);

        winningResults.putIfAbsent(type, 0);
        System.out.println(winningResults.get(type) + PRINT_RESULT_NUM_MESSAGE);
    }

    public static void printEarning(double earning) {
        System.out.print(PRINT_EARNING_START_MESSAGE);
        System.out.printf("%.1f", earning * pourcentage);
        System.out.print(PRINT_EARNING_END_MESSAGE);
    }
}
