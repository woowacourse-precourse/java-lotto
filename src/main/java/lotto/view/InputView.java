package lotto.view;

import lotto.controller.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final Validator validator = new Validator();

    public Integer inputMoney() {
        String input = readLine();
        return validator.validateMoney(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = readLine();
        return validator.validateWinningNumbers(input);
    }

    public Integer inputBonusNumber() {
        String input = readLine();
        return validator.validateBonusNumber(input);
    }
}
