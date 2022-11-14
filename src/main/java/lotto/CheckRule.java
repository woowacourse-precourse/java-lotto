package lotto;

public enum CheckRule {
    FAILSISE("[ERROR] 로또 번호가 잘못 입력되었습니다.\n 로또 번호는 1 ~ 6 자리 입니다."),
    FAILSAMENUMBER("[ERROR] 로또 번호가 중복 되었습니다.\n 중복값은 입력은 안됩니다."),
    FAILPAYMENT("[ERROR] 금액이 잘못 입력되었습니다.\n 금액은 1천원 단위로 입력되어야 합니다.")
    ;

    private String value;
    CheckRule(String s) {
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
