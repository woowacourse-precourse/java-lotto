package lotto.Enum;

public enum Errors {

    NOT_CORRECT_INPUT("[ERROR] 올바르지 않은 입력입니다."),
    NOT_CORRECT_SIZE("[ERROR] 로또 번호는 6자리여야 합니다."),
    NOT_CORRECT_AMOUNT("[ERROR] 1000으로 나누어 떨어지도록 해주세요."),
    NOT_CORRECT_RANGE("[ERROR] 로또 번호는 1부터 45까지 입니다."),
    IS_NOT_UNIQUE("[ERROR] 중복되는 숫자가 있습니다."),
    IS_NATURAL_NUMBER("[ERROR] 금액은 자연수여야 합니다."),
    BONUS_NUMBER_NOT_UNIQUE("[ERROR] 보너스 번호는 당첨번호와 중복이 되면 안됩니다.");
    private final String error;
    Errors(String error) { this.error = error; }
    public String getName() { return error; }
}
