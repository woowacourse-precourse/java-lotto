package lotto;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Win {
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String TITLE_DISTINGUISHING_ROLE = "---";
    private static final String PUTTING_COMMAS_IN_THREE_NUMBERS = "###,###";

    public void statisticsMessage() {
        System.out.println('\n' + WIN_STATISTICS_MESSAGE);
        System.out.println(TITLE_DISTINGUISHING_ROLE);
    }

    private void printStatistics(@NotNull CountNumberOfWins countNumberOfWins) {
        DecimalFormat decimalFormat = new DecimalFormat(PUTTING_COMMAS_IN_THREE_NUMBERS);

        System.out.println("3개 일치 (" + decimalFormat.format(Grade.FIFTH.getPrizeMoney()) + "원) - " + countNumberOfWins.getFifthPlace() + "개");
        System.out.println("4개 일치 (" + decimalFormat.format(Grade.FOURTH.getPrizeMoney()) + "원) - " + countNumberOfWins.getFourthPlace() + "개");
        System.out.println("5개 일치 (" + decimalFormat.format(Grade.THIRD.getPrizeMoney()) + "원) - " + countNumberOfWins.getThirdPlace() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + decimalFormat.format(Grade.SECOND.getPrizeMoney()) + "원) - " + countNumberOfWins.getSecondPlace() + "개");
        System.out.println("6개 일치 (" + decimalFormat.format(Grade.FIRST.getPrizeMoney()) +"원) - " + countNumberOfWins.getFirstPlace() + "개");
        System.out.println("총 수익률은 " + countNumberOfWins.rateOfReturn() + "%입니다.");
    }

    public void statistics() {
        BuyLotto buyLotto = new BuyLotto();
        WinningNumbers winningNumbers = new WinningNumbers();
        CountNumberOfWins countNumberOfWins = new CountNumberOfWins(buyLotto, winningNumbers);

        countNumberOfWins.ranking();
        countNumberOfWins.calculateSumOfPrize();
        statisticsMessage();
        printStatistics(countNumberOfWins);
    }
}
