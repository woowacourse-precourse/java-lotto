package lotto.view;

import lotto.Lotto;
import lotto.Enum.Notice;
import lotto.Enum.Result;

import java.util.List;

public class Output {

    public void inputAmountOutput() {
        System.out.println(Notice.INPUT_AMOUNT.getNotice());
    }

    public void inputWinningNumbersOutput() {
        System.out.println(Notice.INPUT_WINNING_NUMBERS.getNotice());
    }
    public void inputBonusNumberOutput() {
        System.out.println(Notice.INPUT_BONUS_NUMBER.getNotice());
    }

    public void showAllLottos(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            lotto.printSortedNumbers();
        }
    }

    public void printResult(int[] prize, float yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format(Result.FIFTH.getResult(), prize[4]));
        System.out.println(String.format(Result.FOURTH.getResult(), prize[3]));
        System.out.println(String.format(Result.THIRD.getResult(), prize[2]));
        System.out.println(String.format(Result.SECOND.getResult(), prize[1]));
        System.out.println(String.format(Result.FIRST.getResult(), prize[0]));
        System.out.println(String.format(Result.YIELD.getResult(), yield));
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
