package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        InputUserMoney#InputMoney() - 사용자에게 구입금액을 입력
//        UserNumberGenerator#createRandomNumbers() - 구입 금액 만큼 1-45숫자중 중복되지 않는 6개의 숫자를 생성
//        CorrectNumberGenerator#createCorrectNumber() - 1-45 범위의 숫자 중 중복되지 않는 6개의 당첨번호를 생성
//        BonusNumberGenerator#createBonusNumber() - 1-45 범위의 숫자 중 당첨번호와 중복되지 않는 보너스 번호를 입력
//        CompareNumber#jugementNumber() - 구입한 내역의 숫자와 당첨숫자 비교 결과를 반환

        int InputMoney = PrintInputMoneyGenerator.printInputMoney();
        int InputMoenyForCal = InputMoney*1000;

        List<Integer> returnNumber = CompareNumberWithBonus.jugementNumberWithBonus(InputMoney);
        PrintWinnerStatisticsGenerator.printWinner(returnNumber);
        int totalEarningMoney = EarningRateGenerator.printEarningRate(returnNumber);
        CalculateTotalEarningGenerator.calculateTotalEarning(InputMoenyForCal, totalEarningMoney);


    }
}
