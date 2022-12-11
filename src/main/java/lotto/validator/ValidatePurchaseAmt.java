package lotto.validator;

public class ValidatePurchaseAmt implements Validator{
    private final int MIN_UNIT = 1000;

    @Override
    public void validate(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시요.");
        }

        if (Integer.parseInt(input) % MIN_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주십시요.");
        }
    }
}
