package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_STATISTICS_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_STATISTICS_MESSAGE_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    public static void printPurchaseCount(int count) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, count);
    }

    public static void printLottos(Lottos lottoNumbersGroup) {
        lottoNumbersGroup.getLottos()
                .forEach(OutputView::printLotto);
        System.out.println();
    }

    private static void printLotto(Lotto lottoNumbers) {
        StringJoiner result =
                new StringJoiner(LOTTO_NUMBER_SEPARATOR, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX);
        List<Integer> numbers = lottoNumbers.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
        numbers.forEach(number -> result.add(String.valueOf(number)));
        System.out.println(result);
    }

    public static void printCountOfLottoPrize(Map<LottoPrize, Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        for (LottoPrize value : LottoPrize.values()) {
            printCountFormat(value, lottoResult.getOrDefault(value, 0));
        }
    }

    private static void printCountFormat(LottoPrize lottoPrize, int count) {
        System.out.printf(getStatisticsCountMessageFormat(lottoPrize), lottoPrize.getMatchCount(),
                MONEY_FORMAT.format(lottoPrize.getReward()),
                count);
    }

    private static String getStatisticsCountMessageFormat(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.NONE) {
            return "";
        }
        if (lottoPrize == LottoPrize.SECOND) {
            return WINNING_STATISTICS_MESSAGE_BONUS_FORMAT;
        }
        return WINNING_STATISTICS_MESSAGE_FORMAT;
    }
}
