package lotto.IO.message;

import lotto.config.LottoConfig;

public enum IOMessage {
    EMPTY_LINE(""),
    ASK_PRICE("구입금액을 입력해 주세요."),
    LOTTO_BUY_NUM("개를 구매했습니다."),
    ASK_ANSWER("당첨 번호를 입력해 주세요."),
    ASK_BONUS("보너스 번호를 입력해 주세요."),
    RANK_0("6개 일치 (" + LottoConfig.awardsToString.get(0) + "원) - "),
    RANK_1("5개 일치, 보너스 볼 일치 (" + LottoConfig.awardsToString.get(1) + "원) - "),
    RANK_2("5개 일치 (" + LottoConfig.awardsToString.get(2) + "원) - "),
    RANK_3("4개 일치 (" + LottoConfig.awardsToString.get(3) + "원) - "),
    RANK_4("3개 일치 (" + LottoConfig.awardsToString.get(4) + "원) - ");

    private final String message;

    IOMessage(String message) { this.message = message; }
    public String getMessage() { return message; }
}
