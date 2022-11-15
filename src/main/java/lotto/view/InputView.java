package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Constants.COMMA;

public class InputView {

    public int inputMoney() {
        String input = Console.readLine().trim();
        InputValidator.validateMoney(input);

        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningLotto() {
        String input = Console.readLine().trim();
        InputValidator.validateWinningLotto(input);

        return convertWinningLotto(input);
    }

    public int inputBonusNumber() {
        String input = Console.readLine().trim();
        InputValidator.validateBonusNumber(input);

        return Integer.parseInt(input);
    }

    private List<Integer> convertWinningLotto(String input) {
        return Arrays.stream(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
