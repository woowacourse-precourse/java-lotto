package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.validation.WinningValidation;

public class BonusInput extends Input {
    private final WinningValidation validation = new WinningValidation();
    private final List<Integer> winnings;
    private String input;

    public BonusInput(List<Integer> winnings) {
        this.winnings = winnings;
    }

    @Override
    public String getInput() {
        input = readLine();
        validation.isValidBonus(input, this.winnings);
        return input;
    }
}