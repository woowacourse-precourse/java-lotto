package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private final Validator validator;

    public InputHandler() {
        validator = new Validator();
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputString = Console.readLine();
        validator.validateSeriesOfNumbers(inputString);
        int cash = Integer.parseInt(inputString);
        validator.validatePurchaseAmount(cash);
        System.out.println();

        return cash;
    }

    public List<Integer> inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        validator.validateLotto(winNumbers);
        System.out.println();

        return winNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputString = Console.readLine();
        validator.validateSeriesOfNumbers(inputString);
        int bonusNumber = Integer.parseInt(inputString);
        validator.validateBonusNumber(bonusNumber);
        System.out.println();

        return bonusNumber;
    }
}
