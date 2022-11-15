package lotto.service;

public enum LottoGrade {
    FIRST("6개 일치 (2,000,000,000원).2000000000원"), SECOND("5개 일치, 보너스 볼 일치 (30,000,000원).30000000"),
    THIRD("5개 일치 (1,500,000원).1500000"), FOURTH("4개 일치 (50,000원).50000"),
    FIFTH("3개 일치 (5,000원).5000"), DEFAULT("당첨 내역 없음");

    private final String value;

    LottoGrade(String value) {
        this.value = value;

    }

    public String getText() {
        return value.split(".")[0];
    }

    public Integer getValue() {
        return Integer.valueOf(value.split(".")[1]);
    }
}
