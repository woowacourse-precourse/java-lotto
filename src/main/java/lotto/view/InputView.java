package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
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
}
