package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validation.WinningValidation;

public class WinningInput extends Input {
    private final WinningValidation validation = new WinningValidation();
    private String input;

    @Override
    public String getInput() {
        input = readLine();
        validation.isValidWinning(input);
        return input;
    }
}