package lotto.UI;

import java.util.List;

public class BonusNumber {
    private final int number;
    public BonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = convertInputToNumber(input);
        validate(bonusNumber, winningNumbers);
        this.number = bonusNumber;
    }
    public static void validate(int bonusNumber, List<Integer> winningNumbers) {
        Error error = new Error();
        if (bonusNumber == 0) {
            error.outOfRange();
        }
        else if (bonusNumber < 1 || bonusNumber > 45) {
            error.outOfRange();
        }
        else if (winningNumbers.contains(bonusNumber)) {
            error.duplicated();
        }
    }
    public static int convertInputToNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return number;
    }
    public int getNumber() {
        return this.number;
    }
}
