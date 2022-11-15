package lotto;

public enum LottoResult {


    FIRST(2000000000L, "6개 일치 (2,000,000,000원)"),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1500000L, "5개 일치 (1,500,000원)"),
    FOURTH(50000L, "4개 일치 (50,000원)"),
    FIFTH(5000L, "3개 일치 (5,000원)"),
    NOTHING(0L, "");
    private final Long compensation;
    private final String message;

    public Long getCompensation() {
        return compensation;
    }

    public String getMessage() {
        return message;
    }

    LottoResult(Long compensation, String message) {
        this.message = message;
        this.compensation = compensation;
    }
}
