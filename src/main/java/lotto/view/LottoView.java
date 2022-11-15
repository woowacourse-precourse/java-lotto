package lotto.view;

import static lotto.LottoConstant.GAME_START_MESSAGE;
import static lotto.LottoConstant.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.LottoConstant.INPUT_WINNING_LOTTO_NUMBER_MESSAGE;
import static lotto.LottoConstant.PURCHASE_LOTTO_COUNT_RESULT_MESSAGE;
import static lotto.LottoConstant.STATISTICS_PRINT_MESSAGE;
import static lotto.LottoConstant.TOTAL_RATE_MESSAGE_1;
import static lotto.LottoConstant.TOTAL_RATE_MESSAGE_2;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Result;

public class LottoView {

    private static final String totalRateFormat = "%.1f";

    private LottoView() {
    }

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void printLottoPurchaseResult(long purchaseAmount, List<Lotto> lottoNumbers) {
        System.out.println("\n" + purchaseAmount + PURCHASE_LOTTO_COUNT_RESULT_MESSAGE);
        lottoNumbers.forEach(System.out::println);
    }

    public static void printInputLottoWinningMessage() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printResultStatistics(Map<Result, Integer> resultPoints, double rate) {
        System.out.println(STATISTICS_PRINT_MESSAGE);
        Arrays.stream(Result.values()).forEach(result -> System.out.println(
                result.toString(resultPoints.get(result))
        ));
        System.out.println(TOTAL_RATE_MESSAGE_1 + String.format(totalRateFormat, rate) + TOTAL_RATE_MESSAGE_2);
    }
}
