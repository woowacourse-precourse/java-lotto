package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.BudgetValidator;
import lotto.util.validator.WinningNumberValidator;

public class InputView {
    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int readBudget() {
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        String budget = Console.readLine();
        new BudgetValidator().validate(budget);
        return Integer.parseInt(budget);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(ConsoleMessage.INPUT_WINNING_NUMBER.message);
        String input = Console.readLine();
        new WinningNumberValidator().validate(input);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int readBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String bonusNumber = Console.readLine();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        bonusNumberValidator.validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
