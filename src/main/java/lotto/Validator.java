package lotto;

public class Validator {

    public static final String NEED_TO_INPUT_NUMBER = "[ERROR] 숫자를 입력해주세요";
    public static final String NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND
            = "[ERROR] 1000으로 나누어 떨어지는 숫자를 입력해주세요";

    public void validateMoney(String money) {
        valueIsNumber(money);
        valueCanDivideByOneThousand(money);
    }

    private void valueIsNumber(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NEED_TO_INPUT_NUMBER);
        }
    }

    private void valueCanDivideByOneThousand(String money) {
        if (Integer.parseInt(money) / 1000 != 0) {
            throw new IllegalArgumentException(NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND);
        }
    }
}
