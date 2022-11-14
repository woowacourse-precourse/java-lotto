package lotto.view;

public enum View {

    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_ISSUE("%d개를 구매했습니다."),
    OUTPUT_STATISTICS( "당첨 통계"),
    OUTPUT_DOTTED_LINE("---"),
    OUTPUT_WIN_RESULT("%s - %d개"),
    OUTPUT_TOTAL_YIELD("총 수익률은 %.1f%%입니다.");

    private final String message;

    View(final String message) {
        this.message = message;
    }

    String message() {
        return message;
    }
}
