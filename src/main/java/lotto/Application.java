package lotto;

import lotto.View.InputMessage;
import lotto.domain.Budget;
import lotto.domain.Purchase;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.TargetNumbers;

public class Application {
    public static int numberOfGame;

    public static void main(String[] args) {
        try {
            int numberOfGame = Budget.getInstance(getPurchase()).getLottoNumberByBudget();
            Purchase.getInstance(numberOfGame);
            System.out.println("\n"+numberOfGame+InputMessage.PURCHASE_NUMBER_OF_GAME.getValue());
            TargetNumbers.getInstance(getWinNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getPurchase() { // 로또 구입 수행
        System.out.println(InputMessage.PLEASE_INPUT_BUDGET.getValue());
        String money = Console.readLine();
        return money;
    }

    public static String getWinNumber() { // 당첨 번호 입력 수행
        System.out.println(InputMessage.PLEASE_INPUT_WIN_NUMBER.getValue());
        String winNumber=Console.readLine();
        return winNumber;
    }

}
