package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static InputView instance;

    private InputView() {}

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

        String purchaseAmount = Console.readLine();

        InputValidator.validatePurchaseAmount(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        String winningNumbers = Console.readLine();

        InputValidator.validateWinningNumbersFormat(winningNumbers);

        return toNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        String bonusNumber = Console.readLine();

        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> toNumbers(String winningNumbers) {
        List<Integer> numbers = Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        InputValidator.validateWinningNumbersRange(numbers);

        return numbers;
    }
}
