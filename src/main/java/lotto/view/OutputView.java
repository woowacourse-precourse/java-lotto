package lotto.view;

import lotto.domain.*;
import lotto.dto.LottoGameResultDto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static java.text.MessageFormat.format;
import static lotto.utils.ViewMessages.*;

public class OutputView {
    private static final DecimalFormat amountFormat = new DecimalFormat("###,###");
    private static final DecimalFormat profitFormat = new DecimalFormat("#,##0.0");

    private OutputView() {
    }

    public static void printLottoQuantity(int lottoQuantity) {
        printLine();
        System.out.println(format(OUTPUT_LOTTO_QUANTITY, lottoQuantity));
    }

    public static void printLottoNumbers(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.get()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoGameResult(LottoGameResultDto lottoGameResultDto) {
        printLottoDone();
        printLottoResults(lottoGameResultDto.getResults());
        printProfit(lottoGameResultDto.getProfit());
    }

    private static void printLottoDone() {
        printLine();
        System.out.println(OUTPUT_LOTTO_DONE);
        System.out.println(OUTPUT_LINE);
    }

    public static void printLottoResults(List<LottoResult> results) {
        Arrays.stream(LottoResult.values())
            .filter(result -> result != LottoResult.NONE)
            .forEach(result -> System.out.println(getLottoResultMessage(results, result)));
    }

    private static String getLottoResultMessage(List<LottoResult> results, LottoResult lottoResult) {
        if (lottoResult == LottoResult.FIVE_AND_BONUS_MATCH) {
            return toStringLottoResult(results, lottoResult, OUTPUT_BONUS_MATCH_RESULT);
        }
        return toStringLottoResult(results, lottoResult, OUTPUT_MATCH_RESULT);
    }

    private static String toStringLottoResult(
            List<LottoResult> results,
            LottoResult lottoResult,
            String messageFormat
    ) {
        return format(messageFormat,
                lottoResult.getMatchCount(),
                amountFormat.format(lottoResult.getAmount()),
                getLottoMatchCount(results, lottoResult)
        );
    }

    private static int getLottoMatchCount(List<LottoResult> results, LottoResult lottoResult) {
        return (int) results.stream()
                .filter(lottoResult::equals)
                .count();
    }

    private static void printProfit(double profit) {
        String ProfitMessage = format(OUTPUT_RATE_OF_RETURN, profitFormat.format(profit));
        System.out.println(ProfitMessage);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
