package lotto.view;

public enum ErrorMessage {
    ERROR_AMOUNT_NUMBER_MESSAGE("구입금액은 숫자여야 합니다."),
    ERROR_AMOUNT_MESSAGE("구입금액은 1000원 단위여야 합니다."),
    ERROR_LOTTO_NUMBER_MESSAGE("로또번호는 숫자여야 합니다."),
    ERROR_BONUS_NUMBER_MESSAGE("보너스번호는 숫자여야 합니다.");

    private static final String errorPrefix = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

    public String getValue() {
	return errorPrefix + errorMessage;
    }
}
