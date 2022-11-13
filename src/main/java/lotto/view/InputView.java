package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String REST = ",";

    private final InputViewValidator inputViewValidator;

    public InputView() {
        this.inputViewValidator = new InputViewValidator();
    }

    public int inputPurchaseMoney() {
        String text = Console.readLine();
        inputViewValidator.validateNumber(text);
        int inputValue = Integer.parseInt(text);
        inputViewValidator.validateDivideThousand(inputValue);
        return inputValue;
    }

    public List<Integer> inputWinningLotto() {
        String text = Console.readLine();
        inputViewValidator.validateContainRest(text);
        inputViewValidator.validateSplitByRestNumber(text);
        return Arrays.stream(text.split(REST))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String text = Console.readLine();
        inputViewValidator.validateNumber(text);
        return Integer.parseInt(text);
    }
}
