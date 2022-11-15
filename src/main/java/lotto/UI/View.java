package lotto.UI;

public class View {
    public void printMessage(Text text){
        System.out.println(text.getMessage());
    }

    public void printBuyLotto(Integer lottoCount){
        System.out.printf(Text.BUY_LOTTO.getMessage(), lottoCount);
    }

    public void printWinningStatisticsDetail(Integer matchedNumberCount, String formattedAmount, Integer matchedLottoCount){
        System.out.printf(Text.WINNING_STATISTICS_DETAIL.getMessage(), matchedNumberCount, formattedAmount, matchedLottoCount);
    }

    public void printProfitRate(Double profitRate){
        System.out.printf(Text.PROFIT_RATE.getMessage(), profitRate);
    }

}
