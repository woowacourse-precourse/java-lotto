package lotto.UI;

import java.util.List;

public class View {
    public void print(Text text){
        System.out.println(text.getMessage());
    }
    public void print(List<Integer> list) {
        System.out.println(list);
    }

    public void printBuyLotto(Integer lottoCount){
        System.out.printf(Text.BUY_LOTTO.getMessage(), lottoCount);
    }

    public void printStatisticsDetail(Text format, Integer matchedNumberCount, String amount, Integer lottoCount){
        System.out.printf(format.getMessage(), matchedNumberCount, amount, lottoCount);
    }

    public void printProfitRate(Double profitRate){
        System.out.printf(Text.PROFIT_RATE.getMessage(), profitRate);
    }

    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
}
