package lotto.presentation;

import lotto.data.OutputPrint;

public class LottoPrinter {

    public void printTotalProfit(double profit) {
        String[] prints = OutputPrint.OUTPUT_TOTAL_PROFIT.getMessage().split("/");
        System.out.println(prints[0] + profit + prints[1]);
    }
}
