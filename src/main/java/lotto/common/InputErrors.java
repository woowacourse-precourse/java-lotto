package lotto.common;

public enum InputErrors {
    BLANK("빈 값은 요청될 수 없습니다."),
    AMOUNT_NOT_NUMBER("구입 금액은 구분자 없는 숫자만 가능합니다."),
    AMOUNT_UNDER_MINIMUM("구입 금액은 한 장의 가격보다 크거나 같아야 합니다."),
    AMOUNT_OVER_LIMIT("구입 금액은 구매 한도를 넘을 수 없습니다."),
    AMOUNT_NOT_DIVIDABLE("구입 금액은 한 장의 가격으로 나누어 떨어져야 합니다"),
    WIN_NUMBER_NOT_FORMAT("당첨 번호는 공백 없이 \",\"로만 구분된 숫자의 조합만 가능합니다."),
    WIN_NUMBER_MISMATCH_SIZE("당첨 번호는 총 6개이어야 합니다."),
    WIN_NUMBER_OUT_OF_RANGE("당첨 번호는 1 ~ 45사이의 값이어야 합니다."),
    WIN_NUMBER_DUPLICATED("당첨 번호는 중복 될 수 없습니다."),
    BONUS_NUMBER_NOT_NUMBER("보너스 번호는 3자리 이하로 구성된 숫자만 가능합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1 ~ 45사이의 값이어야 합니다."),
    BONUS_NUMBER_DUPLICATED_WIN_NUMBER("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");

    private String message;

    InputErrors(String message) {
        String errorPrefix = "[ERROR]";
        this.message = errorPrefix + message;
    }

    public String getMessage() {
        return message;
    }
}
