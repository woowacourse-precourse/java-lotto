package lotto.domain.message;

public enum Messages {
    INPUT_MONEY("구입금액을 입력해 주세요.\n"),
    INPUT_WIN_LOTTO_NUM("\n당첨 번호를 입력해 주세요.\n"),
    INPUT_WIN_BONUS_NUM("\n보너스 번호를 입력해 주세요.\n"),
    OUTPUT_LOTTO_COUNT("\n%d개를 구매했습니다.\n"),
    OUTPUT_WIN_LIST("\n" +
            "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n"),
    OUTPUT_BENEFIT_RATIO("총 수익률은 %s%%입니다.\n");

    final private String message;

    public String get() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}
