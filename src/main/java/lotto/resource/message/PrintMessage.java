package lotto.resource.message;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;

public enum PrintMessage {
    PAYOUT("구입금액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다.");

    private String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
