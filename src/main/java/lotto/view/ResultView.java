package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.utils.Constant;

public class ResultView {
    private static final String MESSAGE_FOR_LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String WINNING_STATISTICS_FORMAT = "%d개 일치 (%d원) - %d개";

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String WINNING_STATISTICS_ANNOUNCEMENT = "\n당첨 통계\n---\n";

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLottoQuantity(int quantity) {
        System.out.println(Constant.NEW_LINE);
        System.out.printf(MESSAGE_FOR_LOTTO_QUANTITY, quantity);
    }

    public static void printGeneratedLotto(List<LottoGenerator> lottoGenerators) {
        for (LottoGenerator lottoGenerator : lottoGenerators) {
            String numbers = lottoGenerator.getSortedRandomLotto().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(Constant.DELIMITER_FORMAT));
            System.out.println(LEFT_BRACKET + numbers + RIGHT_BRACKET);
        }
    }

    public static void printLottoResult(LottoCalculator lottoCalculator) {
        Map<Rank, Integer> winningResult = lottoCalculator.getWinningResult();
        List<Rank> ranks = Arrays.asList(Rank.values());
        System.out.println(WINNING_STATISTICS_ANNOUNCEMENT);
        for (Rank rank : ranks) {
            printSameNumberCount(rank, winningResult);
        }
    }

    private static void printSameNumberCount(Rank rank, Map<Rank, Integer> winningResult) {
        if (rank.equals(Rank.SECOND)) {
            System.out.printf((WINNING_STATISTICS_WITH_BONUS_FORMAT) + "%n", rank.getSameNumberCount(), rank.getPrize(), winningResult.get(rank));
        }
        if (rank.equals(Rank.NOTHING)) {
            return;
        }
        System.out.printf((WINNING_STATISTICS_FORMAT) + "%n", rank.getSameNumberCount(), rank.getPrize(), winningResult.get(rank));
    }
}
