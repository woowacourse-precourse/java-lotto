package lotto;

import java.util.List;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(String input, List<Integer> pickNumbers) {
        numberValidate(input);
        this.number = Integer.parseInt(input);
        duplicateValidate(pickNumbers);
    }

    private void numberValidate(String input) {
        // 4-1. 보너스 번호가 숫자가 아니면 예외처리를 한다.
        if (!input.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException("숫자가 아닙니다.");
    }

    private void duplicateValidate(List<Integer> pickNumbers) {
        // 4-2. 보너스 번호가 당첨 번호와 중복되면 예외처리를 한다.
        if (pickNumbers.contains(number))
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복되었습니다.");
    }

    public Integer getNumber() {
        return this.number;
    }
}
