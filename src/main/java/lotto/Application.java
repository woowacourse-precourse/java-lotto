package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int InputMoney = PrintInputMoneyGenerator.printInputMoney();
        int InputMoenyForCal = InputMoney*1000;

        // 사용자 구매시 당첨 숫자 출력


        List<Integer> returnNumber = CompareNumberWithBonus.jugementNumberWithBonus(InputMoney);
        PrintWinnerStatisticsGenerator.printWinner(returnNumber);
        int totalEarningMoney = EarningRateGenerator.printEarningRate(returnNumber);
//        System.out.printf("구매금액은 %d원 입니다.\n", InputMoenyForCal);
        CalculateTotalEarningGenerator.calculateTotalEarning(InputMoenyForCal, totalEarningMoney);
    }
}
