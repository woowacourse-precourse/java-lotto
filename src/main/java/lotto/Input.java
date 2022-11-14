package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Output output;

    Input() {
        this.output = new Output();
    }

    public String amount() {
        output.inputAmountOutput();
        return Console.readLine();
    }

    public String winningNumbers() {
        output.inputWinningNumbersOutput();
        return Console.readLine();
    }

    public String bonusNumber() {
        output.inputBonusNumberOutput();
        return Console.readLine();
    }
}
