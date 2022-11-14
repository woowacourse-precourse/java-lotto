package lotto.message;

import lotto.config.LottoConfig;

public class ExceptionMessage {
    public static final String ERROR_DUPLICATED = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    public static final String ERROR_COUNT = String.format("[ERROR] 로또 번호는 %d개여야 합니다.",
            LottoConfig.NUMBER_COUNT);
    public static final String ERROR_RANGE = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConfig.RANGE_MIN, LottoConfig.RANGE_MAX);
}
