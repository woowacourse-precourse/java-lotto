package lotto.message;

public enum ExceptionMessage implements Message {
    LOTTO_FORM_NOT_MATCHED("[ERROR] 로또 형식이 올바르지 않습니다."),
    NOT_DIVIDED_PRISE("[ERROR] 구매 금액은 로또 한 장 금액으로 나누어 떨어져야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
