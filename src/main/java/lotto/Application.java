package lotto;

import lotto.UI.InputMessage;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static int numberOfGame;

    public static void main(String[] args) {
        try {
            int numberOfGame = Budget.getInstance(getPurchase()).getLottoNumberByBudget();
            Purchase.getInstance(numberOfGame);
            System.out.println("\n"+numberOfGame+InputMessage.PURCHASE_NUMBER_OF_GAME.getValue());
            getWinNumber();
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
