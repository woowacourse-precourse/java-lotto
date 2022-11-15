package lotto.shell;

public enum AlertEnumeration {

    AMOUNT_EXCEPTION("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    INVALID_EXCEPTION("[ERROR] '로또 구입 금액, 당첨 번호, 보너스 번호'는 숫자여야 합니다."),
    SIZE_EXCEPTION("[ERROR] 로또 번호 생성은 6개까지 가능합니다.");


    public final String alertName;

    AlertEnumeration(String alertName) {
        this.alertName = alertName;
    }




    public String getAmountEnumeration() {
        return String.valueOf(AMOUNT_EXCEPTION);
    }
    public String getInvalidEnumeration() {
        return String.valueOf(INVALID_EXCEPTION);
    }
    public String getSizeEnumeration() {
        return String.valueOf(SIZE_EXCEPTION);
    }

}
