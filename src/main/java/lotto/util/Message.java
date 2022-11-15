package lotto.util;

public enum Message {

    INPUT_BUY_LOTTO_PRICE("구입금액을 입력해 주세요."),
    BUY_LOTTO(System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator()),
    INPUT_WIN_LOTTO_NUMBER(System.lineSeparator() + "당첨 번호를 입력해 주세요." + System.lineSeparator()),
    INPUT_BONUS_LOTTO_NUMBER(System.lineSeparator() + "보너스 번호를 입력해 주세요." + System.lineSeparator()),
    STATS_WIN_LOTTO(System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator()),
    STATS_RESULT("%d개 일치 (%s원) - %d개" + System.lineSeparator()),
    STATS_RESULT_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + System.lineSeparator()),
    YIELD_RESULT("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
