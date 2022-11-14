package lotto.view;

import java.util.Map;
import lotto.model.domain.Rank;
import lotto.model.dto.WinningStatisticsDto;

public class OutputView {

    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String FIFTH_RANK = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_RANK = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_RANK = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_RANK = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.\n";
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public static void printRequestMoney() {
        System.out.println(REQUEST_MONEY);
    }

    public static void printLottos(String lottos) {
        System.out.println();
        System.out.println(lottos);
    }

    public static void printRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }

    public static void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        Map<Rank, Integer> rankAndRankCount = winningStatisticsDto.getRankAndRankCount();
        double totalYield = winningStatisticsDto.getTotalYield();

        System.out.println(WINNING_STATISTICS);
        System.out.printf(FIFTH_RANK, rankAndRankCount.get(Rank.FIFTH));
        System.out.printf(FOURTH_RANK, rankAndRankCount.get(Rank.FOURTH));
        System.out.printf(THIRD_RANK, rankAndRankCount.get(Rank.THIRD));
        System.out.printf(SECOND_RANK, rankAndRankCount.get(Rank.SECOND));
        System.out.printf(FIRST_RANK, rankAndRankCount.get(Rank.FIRST));
        System.out.printf(TOTAL_YIELD, totalYield);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE, errorMessage);
    }
}
