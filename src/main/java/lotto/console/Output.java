package lotto.console;

import lotto.domain.Lotto;
import lotto.domain.chart.printChart;

import java.util.List;

public class Output {

    public void askPurchaseAmount() {
        System.out.println(printChart.ASK_PURCHASE.getValue());
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.value());
        }
    }

    public void printEmptyLine() {
        System.out.println(printChart.PRINT_EMPTY.getValue());
    }

    public void announceNumber(int number) {
        System.out.println(number + printChart.PRINT_NUMBER.getValue());
    }

    public void askWinningNumber() {
        System.out.println(printChart.ASK_WIN.getValue());
    }

    public void askBonusNumber() {
        System.out.println(printChart.ASK_BONUS.getValue());
    }

    public void printWinningStatistics() {
        System.out.println(printChart.PRINT_STATISTICS.getValue());
    }

    public void printLine() {
        System.out.println(printChart.PRINT_LINE.getValue());
    }

    public void printThree(int threeNumber) {
        System.out.println(printChart.PRINT_THREE.getValue() + threeNumber+printChart.PRINT_GE.getValue());
    }

    public void printFour(int fourNumber) {
        System.out.println(printChart.PRINT_FOUR.getValue() + fourNumber+printChart.PRINT_GE.getValue());
    }

    public void printFive(int fiveNumber) {
        System.out.println(printChart.PRINT_FIVE.getValue() + fiveNumber+printChart.PRINT_GE.getValue());
    }

    public void printFiveFlus(int fiveFlusNumber) {
        System.out.println(printChart.PRINT_FIVE_FLUS.getValue() + fiveFlusNumber+printChart.PRINT_GE.getValue());
    }

    public void printSix(int sixNumber) {
        System.out.println(printChart.PRINT_SIX.getValue() + sixNumber+printChart.PRINT_GE.getValue());
    }

    public void reportRateOfReturn(double totalReturn) {
        System.out.println(printChart.REPORT_RATE.getValue() + totalReturn + printChart.PRINT_PERCENT.getValue());
    }

    public void printErrorMessage(String message){
        System.out.println("[ERROR]"+ message);
    }
}
