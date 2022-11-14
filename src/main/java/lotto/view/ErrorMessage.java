package lotto.view;

public enum ErrorMessage {
    ONLY_NUMBER_POSSIBLE("[ERROR] 숫자만 입력할 수 있습니다."),
    ONLY_ONE_NUMBER_POSSIBLE("[ERROR] 숫자 1개만 입력할 수 있습니다."),
    ONLY_THOUSAND_UNIT_POSSIBLE("[ERROR] 1,000원 단위로 입력 가능합니다."),
    NOT_RIGHT_FORM("[ERROR] 숫자 6개를 쉼표로 구분하여 입력해야 합니다. ex) 1,2,3,4,5,6"),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    DUPLICATE_BONUS("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
