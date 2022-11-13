package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static InputView instance;

    private InputView() {}

    public InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String purchaseAmount = Console.readLine();

        Validator.validatePurchaseAmount(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumbers = Console.readLine();

        Validator.validateWinningNumbersFormat(winningNumbers);

        return toNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = Console.readLine();

        Validator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> toNumbers(String winningNumbers) {
        List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Validator.validateWinningNumbersRange(numbers);

        return numbers;
    }
}
