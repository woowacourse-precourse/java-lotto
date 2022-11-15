package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    Validation validation = new Validation();

    public int inputMoney() {
        String input = Console.readLine();
        while (!validation.isValidMoney(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinNumbers() {
        String input = Console.readLine();
        validation.validateWinNumberInput(input);
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).map(Integer::valueOf).collect(Collectors.toList());
    }

    public int inputBonusNumber(List<Integer> winNumbers) {
        String bonusNumber = Console.readLine();
        validation.validateBonusNumberInput(winNumbers, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
