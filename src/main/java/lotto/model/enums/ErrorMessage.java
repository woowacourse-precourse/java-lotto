package lotto.model.enums;

public enum ErrorMessage {
    LENGTH_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 로또 번호는 중복되어선 안됩니다."),
    DIGIT_ERROR_MESSAGE("[ERROR] 숫자를 입력해야 합니다."),
    SIX_ERROR_MESSAGE("[ERROR] 6개 숫자를 쉼표로 구분하여 띄어쓰기 없이 입력해야 합니다."),
    BONUS_ERROR_MESSAGE("[ERROR] 보너스 번호는 1개만 입력해야 합니다."),
    LUCKY_DUPLICATE_ERROR_MESSAGE("[ERROR] 보너스 번호는 당첨 번호 6개와 중복되면 안됩니다."),
    PRICE_ERROR_MESSAGE("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void printMessage() {
        System.out.println(errorMessage);
    }
}
