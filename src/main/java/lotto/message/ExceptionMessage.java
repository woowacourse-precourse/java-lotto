package lotto.message;

import lotto.config.LottoConfig;

public class ExceptionMessage {
    public static final String ERROR_PRICE = "[ERROR] 로또는 천원 단위로만 구매할 수 있습니다.";
    public static final String ERROR_BUY_PRICE = "[ERROR] 로또는 1000원 이상 21억 이하의 금액으로만 구매할 수 있습니다.";
    public static final String ERROR_DUPLICATED = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    public static final String ERROR_NOT_WINNING_LOTTO = "[ERROR] 당첨되지 않은 로또입니다.";
    public static final String ERROR_COUNT = String.format("[ERROR] 로또 번호는 %d개여야 합니다.",
            LottoConfig.NUMBER_COUNT);
    public static final String ERROR_RANGE = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConfig.RANGE_MIN, LottoConfig.RANGE_MAX);
}
