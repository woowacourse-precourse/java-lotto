package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.TotalLottos;
import lotto.domain.result.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    static final String MATCHING_RECORD_MESSAGE = "%d개 일치 (%,d원) - %d개";
    static final String MATCHING_RECORD_WITH_BONUS_BALL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";

    static final String LINE_BREAK = "\n";
    static final String COMMA_DELIMITER = ", ";
    static final String PREFIX_SQUARE_BRACKET = "[";
    static final String SUFFIX_SQUARE_BRACKET = "]";
    static final String DIVIDING_LINE = "---";

    public static void printLottoPurchaseCount(long lottoCount) {
        System.out.printf(LINE_BREAK + "%d" + LOTTO_PURCHASE_MESSAGE + LINE_BREAK, lottoCount);
    }

    public static void printLottoWithSquareBrackets(List<Integer> lotto) {
        String printingLotto = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMITER, PREFIX_SQUARE_BRACKET, SUFFIX_SQUARE_BRACKET));

        System.out.println(printingLotto);
    }

    public static void printTotalLottos(TotalLottos totalLottos) {
        List<Lotto> printingTotalLottos = totalLottos.getTotalLottos();

        printingTotalLottos.stream()
                .forEach(lotto ->
                        printLottoWithSquareBrackets(lotto.getNumbers())
                );
    }

    public static void printStatistics(Map<LottoRank, Integer> lottoResult) {
        System.out.println(LINE_BREAK + WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);

        for (LottoRank lottoRank : lottoResult.keySet()) {
            if (lottoRank == LottoRank.FAIL) {
                continue;
            }

            printWinningResult(lottoResult, lottoRank);
        }
    }

    public static void printWinningResult(Map<LottoRank, Integer> lottoResult, LottoRank lottoRank) {
        String printingStatistics = String.format(MATCHING_RECORD_MESSAGE, lottoRank.getMatchingCount(), lottoRank.getPrizeMoney(), lottoResult.get(lottoRank));

        String printingStatisticsWithBonusBall = String.format(MATCHING_RECORD_WITH_BONUS_BALL_MESSAGE, lottoRank.getMatchingCount(), lottoRank.getPrizeMoney(), lottoResult.get(lottoRank));

        if (lottoRank == LottoRank.SECOND) {
            System.out.println(printingStatisticsWithBonusBall);
            return;
        }

        System.out.println(printingStatistics);
    }
}
