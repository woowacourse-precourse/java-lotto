package lotto.message;

import lotto.config.LottoConfig;

public enum ExceptionMessage {
    ERROR_FORMAT("잘못된 값을 입력하였습니다."),
    ERROR_PRICE("로또는 천원 단위로만 구매할 수 있습니다."),
    ERROR_BUY_PRICE("로또는 1000원 이상 21억 이하의 금액으로만 구매할 수 있습니다."),
    ERROR_DUPLICATED("로또 번호는 서로 중복되지 않아야 합니다."),
    ERROR_COUNT(String.format("로또 번호는 %d개여야 합니다.", LottoConfig.NUMBER_COUNT)),
    ERROR_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConfig.RANGE_MIN, LottoConfig.RANGE_MAX));

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
