package lotto;

public enum ExceptionMessage {
    NumbersOnly("[ERROR] 구입 금액의 입력은 숫자만 가능합니다."),
    PurchaseUnit("[ERROR] 로또 구입의 최소 단위는 1,000원입니다."),
    Duplicated("[ERROR] 중복되는 숫자를 입력하셨습니다."),
    NotValidateNum("[ERROR] 당첨번호는 1부터 45사이의 숫자 6개를 입력해야 합니다."),
    NotValidateBonusNum("[ERROR] 보너스 번호는 1부터 45사이의 숫자를 입력해야 합니다.");

    final private String msg;
    public String getMsg() {
        return msg;
    }
    ExceptionMessage(String msg) {
        this.msg=msg;
    }
}