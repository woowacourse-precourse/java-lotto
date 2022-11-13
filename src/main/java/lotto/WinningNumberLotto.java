package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class WinningNumberLotto extends Lotto {

    private int bonusNumber;

    public WinningNumberLotto() {
        super(new ArrayList<>());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int inputBonusNumber() {
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input) {

    }

    private void printBonusMessage() {

    }
}
