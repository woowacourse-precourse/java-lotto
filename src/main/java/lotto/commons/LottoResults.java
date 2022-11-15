package lotto.commons;

public enum LottoResults {
    FIRST_WIN("6개 일치 (2,000,000,000원)"),
    SECOND_WIN("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_WIN("5개 일치 (1,500,000원)"),
    FIRTH_WIN("4개 일치 (50,000원)"),
    FIFTH_WIN("3개 일치 (5,000원)");

    private final String result;

    LottoResults(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
