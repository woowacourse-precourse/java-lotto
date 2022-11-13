package lotto.ui;

public enum ErrorMessages {
    INPUT_IS_EMPTY("입력값이 비어있습니다."), INPUT_IS_NOT_NUBMER("숫자만 입력 가능합니다."), INPUT_IS_NOT_DIVIDED_BY_UNIT_PRICE(
            "구매 금액은 %d원 단위로 입력해야합니다."), INPUT_IS_NOT_IN_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."), INPUT_IS_NOT_UNIQUE(
                    "중복된 숫자는 입력할 수 없습니다."), INPUT_IS_NOT_SIX("6개의 숫자를 입력해주세요."), INPUT_IS_NOT_POSITIVE("양수만 입력 가능합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
