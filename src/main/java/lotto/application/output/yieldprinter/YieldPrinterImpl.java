package lotto.application.output.yieldprinter;

public class YieldPrinterImpl implements YieldPrinter {

    public void showYield(double yield) {
        System.out.printf("총 수익률은 %s%%입니다.", yield);
    }
}
