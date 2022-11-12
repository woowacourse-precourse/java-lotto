package lotto;

import java.util.List;

public class BonusNum {
    private final Integer number;

    public BonusNum(String input, List<Integer> pickNumbers) {
        numberValidate(input);
        this.number = Integer.parseInt(input);
        duplicateValidate(pickNumbers);
    }

    private void numberValidate(String input) {
        // 4-1. 보너스 번호가 숫자가 아니면 예외처리를 한다.
        if (!input.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException();
    }

    private void duplicateValidate(List<Integer> pickNumbers) {
        // 4-2. 보너스 번호가 당첨 번호와 중복되면 예외처리를 한다.
        if (pickNumbers.contains(number)) throw new IllegalArgumentException();
    }

    public Integer getNumber() {
        return this.number;
    }
}
