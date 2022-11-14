package lotto.IO.message;

public enum ErrorCode {
    WRONG_LOTTO_PRICE("로또 가격이 잘못 설정되었습니다."),
    WRONG_SIZE("로또 번호는 수 6개로 이루어져야 합니다."),
    DUPLICATE("로또 번호가 중복됩니다."),
    OUT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_PURCHASE_PRICE("구매 금액이 잘못되었습니다."),
    WRONG_ANSWER("당첨 번호를 양식에 맞게 입력해주세요(숫자와 콤마로 구분)");

    private final String value;

    ErrorCode(String value) { this.value = value; }
    public String getValue() { return value; }
}
