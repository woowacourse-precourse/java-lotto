package lotto.Utils;

import static lotto.Enum.InformationMessage.*;
import static lotto.Enum.StatisticMessage.STATISTIC;
import static lotto.Enum.StatisticMessage.*;

public class Printer {
    public void inputMoney() {
        System.out.println(INPUT_AMOUNT_OF_MONEY_TO_BUY.getMessage());
    }

    public void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_WINNING_NUMBER.getMessage());
    }

    public void lottoCount() {
        System.out.println(COUNT_OF_LOTTO.getMessage());
    }

    public void statistic() {
        System.out.println(STATISTIC.getMessage());
    }

    public void winning5(int count) {
        String message = WINNING_5RANK.getMessage() + count;
        System.out.println(message + SUFFIX);
    }

    public void winning4(int count) {
        String message = WINNING_4RANK.getMessage() + count;
        System.out.println(message + SUFFIX);
    }

    public void winning3(int count) {
        String message = WINNING_3RANK.getMessage() + count;
        System.out.println(message + SUFFIX);
    }

    public void winning2(int count) {
        String message = WINNING_2RANK.getMessage() + count;
        System.out.println(message + SUFFIX);
    }

    public void winning1(int count) {
        String message = WINNING_1RANK.getMessage() + count;
        System.out.println(message + SUFFIX);
    }

    public void totalYield(double yield) {
        String message = TOTAL_YIELD.getMessage();
        System.out.printf(message, yield);
    }

}
