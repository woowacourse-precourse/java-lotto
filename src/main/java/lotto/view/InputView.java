package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.BudgetValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int readBudget() {
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        String input = Console.readLine();
        new BudgetValidator().validate(input);
        return Integer.parseInt(input);
    }
}
