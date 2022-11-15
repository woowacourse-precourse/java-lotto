package Exception;

public enum ErrorMessage {

    ERROR_HEADER("[ERROR]"),
    ERROR_PURCHASED_DATAFORMAT(" 구매 금액 입력 형식이 다릅니다."),
    ERROR_PURCHASED_RANGE(" 구매 금액은 0보다 커야합니다."),
    ERROR_PURCHASED_UNIT(" 구매 금액은 1000단위로 입력해야 합니다."),
    ERROR_BONUS_RANGE(" 보너스 번호의 범위가 다릅니다."),
    ERROR_BONUS_DUPLICATE(" 보너스 번호가 로또 번호와 중복된 값입니다."),
    ERROR_LOTTO_NUMBER(" 로또 번호 개수가 다릅니다."),
    ERROR_LOTTO_RANGE(" 올바르지 않은 로또 번호입니다."),
    ERROR_LOTTO_DUPLICATE(" 로또 번호 사이에 중복이 존재합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return message;
    }
}
