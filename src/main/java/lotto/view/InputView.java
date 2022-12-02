package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.BudgetValidator;
import lotto.util.ExceptionMessage;
import lotto.util.WinningNumberValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요.");
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

    public List<Integer> readWinningNumber() {
        System.out.println(ConsoleMessage.INPUT_WINNING_NUMBER.message);
        String input = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
        new WinningNumberValidator().validate(input);

    }
}
