package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.validation.WinningValidation;

public class BonusInput extends Input {
    private final WinningValidation validation = new WinningValidation();
    private final List<Integer> winningNumbers;
    private String input;

    public BonusInput(List<Integer> winningNumber) {
        this.winningNumbers = winningNumber;
    }

    @Override
    public String getInput() {
        input = readLine();
        validation.isValidBonus(input, this.winningNumbers);
        return input;
    }
}