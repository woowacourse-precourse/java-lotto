package lotto.data;

public enum OutputForm {
    OUTPUT_STATISTIC("당첨 통계"),
    OUTPUT_BORDER("---"),
    OUTPUT_PROFIT("총 수익률은 "),
    OUTPUT_COUNT("개를 구매했습니다.");

    private final String message;

    OutputForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
