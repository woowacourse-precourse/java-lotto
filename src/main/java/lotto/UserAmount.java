package lotto;

public class UserAmount {

    private static final int INPUT_AMOUNT_LENGTH_ZERO = 0;
    private static final String INPUT_AMOUNT_SPACE = " ";

    private final Long amount;

    public UserAmount(String amount) {
        this.amount = validate(amount);
    }

    private Long validate(String amount) {
        validateEmpty(amount);
        validateBlank(amount);
        return validateNumber(amount);
    }

    private void validateEmpty(String amount) {
        if (amount.length() == INPUT_AMOUNT_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String amount) {
        if (amount.contains(INPUT_AMOUNT_SPACE)) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private Long validateNumber(String amount) {
        try {
            return Long.parseLong(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력하신 구입금액은 숫자가 아닙니다.");
        }
    }

    public Long getAmount() {
        return this.amount;
    }

}
