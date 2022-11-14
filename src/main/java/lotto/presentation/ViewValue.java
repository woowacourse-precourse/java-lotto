package lotto.presentation;

public enum ViewValue {

    BUY_INFO_MESSAGE("구매금액을 입력해 주세요."),
    BUY_INFO_DONE("개를 구매했습니다.");

    private final String value;

    ViewValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
