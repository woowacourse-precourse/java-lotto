package lotto.model;

public enum ErrorMessage {

    ERROR_MESSAGE("[ERROR]"),
    ERROR_PURCHASED_DATAFORMAT(" 올바른 구매 금액을 입력하세요."),
    ERROR_PURCHASED_RANGE(" 구매 금액은 1000원 이상 입력하세요."),
    ERROR_PURCHASED_UNIT(" 구매 금액을 1000원 단위로 입력하세요"),
    ERROR_BONUS_RANGE(" 보너스 번호의 범위는 1-45 입니다"),
    ERROR_BONUS_DUPLICATION(" 보너스번호는 당첨 번호와 중복되지 않은 번호만 가능합니다."),
    ERROR_LOTTO_NUMBER_SIZE(" 로또번호는 6개 입니다."),
    ERROR_LOTTO_RANGE("올바른 로또 번호를 입력해주세요"),
    ERROR_LOTTO_DUPLICATION(" 로또 번호 사이에 중복이 존재합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
