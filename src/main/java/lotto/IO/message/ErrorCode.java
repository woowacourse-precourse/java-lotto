package lotto.IO.message;

public enum ErrorCode {
    WRONG_SIZE("로또 번호는 수 6개로 이루어져야 합니다."),
    DUPLICATE("중복되는 로또 번호는 생성될 수 없습니다."),
    OUT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_PRICE_ZERO("로또 금액은 0원이 될 수 없습니다."),
    WRONG_PURCHASE_TYPE("로또 구매 금액은 자연수여야 합니다."),
    WRONG_PURCHASE_PRICE("로또 구매 금액은 로또 금액의 배수여야 합니다."),
    WRONG_ANSWER("당첨 번호는 콤마(,)로 구분된 숫자로 이루어져야 합니다.");

    private final String value;

    ErrorCode(String value) { this.value = value; }
    public String getValue() { return value; }
}
