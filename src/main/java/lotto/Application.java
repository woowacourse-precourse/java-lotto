package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        int InputMoney = PrintInputMoneyGenerator.printInputMoney();
        int InputMoenyForCal = InputMoney*1000;

        List<Integer> returnNumber = CompareNumberWithBonus.jugementNumberWithBonus(InputMoney);
        PrintWinnerStatisticsGenerator.printWinner(returnNumber);
        int totalEarningMoney = EarningRateGenerator.printEarningRate(returnNumber);
        CalculateTotalEarningGenerator.calculateTotalEarning(InputMoenyForCal, totalEarningMoney);
    }
}
