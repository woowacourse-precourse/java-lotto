package lotto.domain;

import java.util.Set;

public class BonusNumber {
    private int bonusNumber;

    public void inputBonusNumber(String input, Set<Integer> winningNumber) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
        if (!isRangeNumber()) {
            throw new IllegalArgumentException(Error.IS_NOT_RANGE.getMessage());
        }
        if (isUnique(winningNumber)) { //얜 느낌표 없네
            throw new IllegalArgumentException(Error.IS_NOT_UNIQUE.getMessage());
        }
    }

    private boolean isUnique(Set<Integer> winningNuber) {
        return winningNuber.contains(bonusNumber);
    }

    private boolean isRangeNumber() {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }

    private boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char number = input.charAt(i);
            if (number < '0' || number > '9') {
                return false;
            }
        }
        bonusNumber = Integer.parseInt(input);
        return true;
    }

}
