package lotto.presentation;

import lotto.data.OutputPrint;

public class LottoPrinter {

    public void printTotalProfit(double profit) {
        String[] prints = OutputPrint.OUTPUT_TOTAL_PROFIT.getMessage().split("/");
        System.out.println(prints[0] + profit + prints[1]);
    }

    public void printLottoCount(int count) {
        System.out.println(count + OutputPrint.OUTPUT_LOTTO_COUNT.getMessage());
    }
}
