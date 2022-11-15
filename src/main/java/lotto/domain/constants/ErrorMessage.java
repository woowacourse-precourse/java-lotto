package lotto.domain.constants;

public enum ErrorMessage {
    LOTTO_INVALID_SIZE("로또 번호 숫자의 개수가 적절하지 않습니다."),
    LOTTO_OUT_OF_BOUNDS("로또 번호 숫자의 범위가 적절하지 않습니다."),
    LOTTO_DUPLICATED("로또 번호는 중복된 숫자를 가질 수 없습니다."),

    MONEY_NEGATIVE("금액은 음수일 수 없습니다."),

    PAYMENT_HAS_REMAINDER("거스름돈이 필요 없는 금액만 허용됩니다."),
    PAYMENT_INSUFFICIENT("최소 구매 금액보다 적은 금액을 입력하였습니다."),

    AMOUNT_INSUFFICIENT("로또 구매 개수는 최소 1개입니다."),

    RESULT_RANK_ILLEGAL("당첨 내역의 등수 목록이 로또 등수 정보와 일치하지 않습니다."),
    RESULT_RANK_NOT_COUNTED("비어 있는 등수 목록입니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
