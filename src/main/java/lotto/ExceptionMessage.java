package lotto;

public enum ExceptionMessage {
    NumbersOnly("[ERROR] 구입 금액의 입력은 숫자만 가능합니다."),
    PurchaseUnit("[ERROR] 로또 구입의 최소 단위는 1,000원입니다.");

    final private String msg;
    public String getMsg() {
        return msg;
    }
    private ExceptionMessage(String msg) {
        this.msg=msg;
    }
}