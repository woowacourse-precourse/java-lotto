package lotto;

public class BonusNum {
    private final Integer number;

    public BonusNum(String input) {
        numberValidate(input);
        this.number = Integer.parseInt(input);
    }

    private void numberValidate(String input) {
        // 4-1. 보너스 번호가 숫자가 아니면 예외처리를 한다.
        if (!input.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException();
    }
}
