package lotto.data;

import java.util.function.Function;

public enum OutputPrint {
    OUTPUT_BORDER("---"),
    OUTPUT_WINNING_STATISTIC("당첨 통계"),
    OUTPUT_TOTAL_PROFIT("총 수익률은 /%입니다."),
    OUTPUT_LOTTO_COUNT("개를 구매했습니다.");

    private final String message;

    OutputPrint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(getMessage());
    }
}
