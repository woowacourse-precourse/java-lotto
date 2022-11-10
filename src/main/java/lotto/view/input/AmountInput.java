package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validation.AmountValidation;

public class AmountInput extends Input {
    private final AmountValidation validation = new AmountValidation();
    private String input;

    public AmountInput() {
    }

    @Override
    public String getInput() {
        input = readLine();
        validation.isValid(input);
        return input;
    }
}