package lotto;

import lotto.UI.InputMessage;
import lotto.domain.Budget;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int numberOfGame;

    public static void main(String[] args) {
        try {
            int numberOfGame = Budget.from(getPurchase()).getBudgetNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getPurchase() { // 로또 구입 수행
        System.out.println(InputMessage.PLEASE_INPUT_BUDGET.getValue());
        String money = Console.readLine();
        return money;
    }

    public static void getWinNumber() {
        System.out.println(InputMessage.PLEASE_INPUT_WIN_NUMBER.getValue());
    }

}
