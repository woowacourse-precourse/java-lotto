package lotto.view;

import lotto.domain.Rank;
import lotto.dto.ResponseRankAggregation;
import lotto.service.YieldService;

import java.text.DecimalFormat;

public class WinningHistoryView {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private static YieldService yieldService = new YieldService();

    public static void showRankAggregation(ResponseRankAggregation responseRankAggregation, String pay) {
        showAggregationForm();
        showFifthRankCount(responseRankAggregation.getFifthRankCount());
        showFourthRankCount(responseRankAggregation.getFourthRankCount());
        showThirdRankCount(responseRankAggregation.getThirdRankCount());
        showSecondRankCount(responseRankAggregation.getSecondRankCount());
        showFirstRankCount(responseRankAggregation.getFirstRankCount());
        showYield(responseRankAggregation, pay);
    }

    private static void showAggregationForm() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void showFirstRankCount(int firstRankCount) {
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FIRST.getMatchCount(), decimalFormat.format(Rank.FIRST.getWinningMoney()), firstRankCount);
    }

    private static void showSecondRankCount(int secondRankCount) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", Rank.SECOND.getMatchCount(), decimalFormat.format(Rank.SECOND.getWinningMoney()), secondRankCount);
    }

    private static void showThirdRankCount(int thirdRankCount) {
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.THIRD.getMatchCount(), decimalFormat.format(Rank.THIRD.getWinningMoney()), thirdRankCount);
    }

    private static void showFourthRankCount(int fourthRankCount) {
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FOURTH.getMatchCount(), decimalFormat.format(Rank.FOURTH.getWinningMoney()), fourthRankCount);
    }

    private static void showFifthRankCount(int fifthRankCount) {
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FIFTH.getMatchCount(), decimalFormat.format(Rank.FIFTH.getWinningMoney()), fifthRankCount);
    }

    private static void showYield(ResponseRankAggregation responseRankAggregation, String pay) {
        String calculate = yieldService.calculate(responseRankAggregation, pay);
        System.out.println("총 수익률은 " + calculate + "%입니다.");
    }
}
