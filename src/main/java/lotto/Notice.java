package lotto;

public enum Notice {

    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    LOTTO_COUNT("\n%d개를 구매했습니다."),
    LOTTO_NUMBER("%s"),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해주세요."),
    WINNING_STATUS("\n당첨 통계\n"
        + "---\n"
        + "3개 일치 (5,000원) - %d개\n"
        + "4개 일치 (50,000원) - %d개\n"
        + "5개 일치 (1,500,000원) - %d개\n"
        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
        + "6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
