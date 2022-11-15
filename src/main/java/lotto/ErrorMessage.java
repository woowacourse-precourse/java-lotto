package lotto;

public enum ErrorMessage {
    INPUT_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    SIZE_ERROR("[ERROR] 로또 번호는 6자리여야 합니다."),
    MONEY_ERROR("[ERROR] 로또는 1000원으로 나누어 떨어지는 금액만 가능합니다."),
    LOTTO_INPUT_ERROR("[ERROR] 1~45사이의 숫자 6개를 쉼표로 구분하여 입력해야 합니다."),
    BONUS_ERROR("[ERROR] 보너스 숫자는 로또 번호와 중복되면 안됩니다."),
    LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
