package lotto.view;

import lotto.domain.LottoQuantity;
import lotto.domain.RateOfReturn;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.enums.LottoResult;

import java.text.DecimalFormat;
import java.util.Arrays;

import static lotto.utils.ViewMessages.*;

public class OutputView {
    static DecimalFormat decimalFormat = new DecimalFormat("###,###");

    private OutputView() {
    }

    public static void printLottoQuantity(LottoQuantity lottoQuantity) {
        System.out.printf(OUTPUT_LOTTO_QUANTITY, lottoQuantity.getCount());
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(lotto ->
                System.out.println(lotto.getNumbers())
        );
    }

    public static void printLottoResult(LottoResults results) {
        printLottoDone();
        Arrays.stream(LottoResult.values())
            .filter(result -> result.getMatchCount() != 0)
            .forEach(result -> {
                int count = getLottoMatchCount(results, result);
                printResult(result, count);
            });
    }

    private static int getLottoMatchCount(LottoResults results, LottoResult result) {
        return (int) results.getResults().stream()
                .filter(result::equals)
                .count();
    }

    private static void printResult(LottoResult result, int count) {
        int lottoMatchCount = result.getMatchCount();
        String lottoAmount = decimalFormat.format(result.getAmount());

        if (result.hasBonusNumber()) {
            System.out.printf(OUTPUT_BONUS_MATCH_RESULT, lottoMatchCount, lottoAmount, count);
        }
        if (!result.hasBonusNumber()) {
            System.out.printf(OUTPUT_MATCH_RESULT, lottoMatchCount, lottoAmount, count);
        }
    }

    private static void printLottoDone() {
        System.out.println(OUTPUT_LOTTO_DONE);
        System.out.println(OUTPUT_LINE);
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        double rate = rateOfReturn.getRateOfReturn();
        System.out.printf(OUTPUT_RATE_OF_RETURN, String.format("%.1f", rate));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
