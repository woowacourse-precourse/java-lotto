package lotto.view;

public enum Messages {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRIZE_STATISTIC("당첨 통계"),
    LINE_STATISTIC("---"),
    PRIZE_RESULT("%d개 일치 (%s) - %d개"),
    PRIZE_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s) - %d개"),
    GROSS_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
