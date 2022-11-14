package lotto;

public class Win {
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String TITLE_DISTINGUISHING_ROLE = "---";
    private static final String FIFTH_GRADE_STATISTICS_MESSAGE = "3개 일치 (5,000원) - %d개%n";
    private static final String FOURTH_GRADE_STATISTICS_MESSAGE = "4개 일치 (50,000원) - %d개%n";
    private static final String THIRD_GRADE_STATISTICS_MESSAGE = "5개 일치 (1,500,000원) - %d개%n";
    private static final String SECOND_GRADE_STATISTICS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String FIRST_GRADE_STATISTICS_MESSAGE = "6개 일치 (2,000,000,000원) - %d개%n";
    private static final String RATE_OF_RETURNS_MESSAGE = "총 수익률은 %2.1f%s입니다.";
    private static final String PERCENT_CHARACTER = "%";

    public void statisticsMessage() {
        System.out.println('\n' + WIN_STATISTICS_MESSAGE);
        System.out.println(TITLE_DISTINGUISHING_ROLE);
    }

    private void printStatistics(CountNumberOfWins countNumberOfWins) {
        System.out.printf(FIFTH_GRADE_STATISTICS_MESSAGE, countNumberOfWins.getFifthPlace());
        System.out.printf(FOURTH_GRADE_STATISTICS_MESSAGE, countNumberOfWins.getFourthPlace());
        System.out.printf(THIRD_GRADE_STATISTICS_MESSAGE, countNumberOfWins.getThirdPlace());
        System.out.printf(SECOND_GRADE_STATISTICS_MESSAGE, countNumberOfWins.getSecondPlace());
        System.out.printf(FIRST_GRADE_STATISTICS_MESSAGE, countNumberOfWins.getFirstPlace());
        System.out.printf(RATE_OF_RETURNS_MESSAGE, countNumberOfWins.rateOfReturn(), PERCENT_CHARACTER);
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
