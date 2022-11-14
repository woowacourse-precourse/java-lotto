package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private final InputValidator inputValidator;

    public InputHandler() {
        inputValidator = new InputValidator();
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int cash = Integer.parseInt(Console.readLine());

        inputValidator.validatePurchaseAmount(cash);
        return cash;
    }

    public List<Integer> inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        inputValidator.validateLotto(winNumbers);

        return winNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        inputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
