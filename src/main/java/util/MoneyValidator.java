package util;

public class MoneyValidator {

    private static final int MIN_MONEY = 1000;
    private static final int MONEY_UNIT = 1000;
    private static final String ERROR_TYPE = "[ERROR] 금액은 숫자로만 입력해주세요.";
    private static final String ERROR_UNIT = "[ERROR] 1000원 단위로 금액을 입력해야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 1000원 이상 내셔야 로또 구매가 가능합니다.";

    String money;

    public MoneyValidator(String money) {
        this.money = money;
        validate();
    }

    private void validate() {
        validateType();
        validateRange();
        validateUnit();
    }

    private void validateUnit() {
        if (Integer.parseInt(money) % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    private void validateRange() {
        if (Integer.parseInt(money) < MIN_MONEY) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void validateType() {
        try{
            Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }
}
