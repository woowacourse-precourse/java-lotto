package lotto.IO.message;

import lotto.config.LottoConfig;

public enum IOMessage {
    EMPTY_LINE(""),
    ASK_PRICE("구입금액을 입력해 주세요."),
    LOTTO_BUY_NUM("개를 구매했습니다."),
    ASK_ANSWER("당첨 번호를 입력해 주세요."),
    ASK_BONUS("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계\n---"),
    RANK_0("6개 일치 (%,d원) - %d개\n"),
    RANK_1("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    RANK_2("5개 일치 (%,d원) - %d개\n"),
    RANK_3("4개 일치 (%,d원) - %d개\n"),
    RANK_4("3개 일치 (%,d원) - %d개\n");

    private final String message;

    IOMessage(String message) { this.message = message; }
    public String getMessage() { return message; }
}
