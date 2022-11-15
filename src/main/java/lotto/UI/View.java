package lotto.UI;

public class View {
    public void printBudgetInput(){
        System.out.println(Text.BUDGET_INPUT.getMessage());
    }

    public void printButLotto(Integer lottoCount){
        System.out.printf(Text.BUY_LOTTO.getMessage(), lottoCount);
    }

    public void printWinningNumberInput(){
        System.out.println(Text.WINNING_NUMBER_INPUT.getMessage());
    }

    public void printBonusNumberInput(){
        System.out.println(Text.BONUS_NUMBER_INPUT.getMessage());
    }

    public void printWinningStatisticsTitle(){
        System.out.println(Text.WINNING_STATISTICS_TITLE.getMessage());
    }

    public void printWinningStatisticsDetail(Integer matchedNumberCount, String formattedAmount, Integer matchedLottoCount){
        System.out.printf(Text.WINNING_STATISTICS_DETAIL.getMessage(), matchedNumberCount, formattedAmount, matchedLottoCount);
    }

    public void printProfitRate(Double profitRate){
        System.out.printf(Text.PROFIT_RATE.getMessage(), profitRate);
    }

}
