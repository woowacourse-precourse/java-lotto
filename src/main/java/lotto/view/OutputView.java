package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;

import java.text.DecimalFormat;
import java.util.Map;

import static lotto.domain.Preset.LINE_FEED;
import static lotto.domain.Preset.percentage;

public class OutputView {

    public static final String READ_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String LOTTO_PRINT_FORMAT = "[%d, %d, %d, %d, %d, %d]";
    public static final String PRINT_PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";
    public static final String PRINT_RESULT_MAIN_MESSAGE = "당첨 통계\n" + "---";
    public final static String PRINT_RESULT_EQUAL_MESSAGE = "개 일치";
    public final static String PRINT_RESULT_BONUS_MESSAGE = ", 보너스 볼 일치";
    public final static String PRINT_RESULT_WINNING_START_MESSAGE = " (";
    public final static String PRINT_RESULT_WINNING_END_MESSAGE = "원) - ";
    public final static String PRINT_RESULT_NUM_MESSAGE = "개";
    public static final String PRINT_EARNING_START_MESSAGE = "총 수익률은 ";
    public static final String PRINT_EARNING_END_MESSAGE = "%입니다.";

    public static void printPurchaseNum(int number) {
        System.out.println(LINE_FEED + number + PRINT_PURCHASE_NUM_MESSAGE);
    }

    public static void printResult(WinningLotto winningLotto, Lottos lottos, int inputMoney) {
        printResultMainMessage();

        WinningResult result = new WinningResult(winningLotto, lottos);
        result.print();

        double earning = result.calculateEarning(inputMoney);
        printEarning(earning);
    }

    public static void printResultMainMessage() {
        System.out.println(PRINT_RESULT_MAIN_MESSAGE);
    }

    public static void printEachWinningResult(WinningType type, Map<WinningType, Integer> winningResults) {
        if (type == WinningType.NONE) return;

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String decimatedWinning = decimalFormat.format(type.getWinnings());

        System.out.print(type.getEqualCount() + PRINT_RESULT_EQUAL_MESSAGE);

        if (type.getWithBonus()) System.out.print(PRINT_RESULT_BONUS_MESSAGE);

        System.out.print(PRINT_RESULT_WINNING_START_MESSAGE + decimatedWinning + PRINT_RESULT_WINNING_END_MESSAGE);
        System.out.println(winningResults.get(type) + PRINT_RESULT_NUM_MESSAGE);
    }

    public static void printEarning(double earning) {
        System.out.print(PRINT_EARNING_START_MESSAGE);
        System.out.printf("%.1f", earning * percentage);
        System.out.println(PRINT_EARNING_END_MESSAGE);
    }
}
