package lotto;

import lotto.View.ErrorMessage;
import lotto.View.InputMessage;
import lotto.domain.Budget;
import lotto.domain.Purchase;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Statistics;
import lotto.domain.TargetNumbers;

public class Application {
    public static void main(String[] args) {
        try {
            int numberOfGame = Budget.getInstance(getMoney()).getLottoNumberByBudget();
            Purchase.getInstance(numberOfGame);
            TargetNumbers.getInstance(getWinNumber());
            int bonusNumber=getBonusNumber();
            Statistics.getInstance(Purchase.getPurchasedNumbers(),bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getMoney() {
        System.out.println(InputMessage.PLEASE_INPUT_BUDGET.getValue());
        String money = Console.readLine();
        return money;
    }

    public static String getWinNumber() {
        System.out.println(InputMessage.PLEASE_INPUT_WIN_NUMBER.getValue());
        String winNumber = Console.readLine();
        return winNumber;
    }

    public static int getBonusNumber() {
        System.out.println(InputMessage.PLEASE_INPUT_EXTRA_NUMBER.getValue());
        String bonusNumber = Console.readLine();
        isBonusNumberValid(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public static void isBonusNumberValid(String bonusNumber) throws IllegalArgumentException {
        boolean notDigit = bonusNumber.chars().anyMatch(Character::isDigit);
        if (!notDigit) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.getValue());
        }
        if ((45 < Integer.parseInt(bonusNumber) || Integer.parseInt(bonusNumber) < 1)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE.getValue());
        }
    }
}
