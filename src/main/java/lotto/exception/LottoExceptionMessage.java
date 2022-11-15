package lotto.exception;

import static lotto.domain.LottoSetting.LOTTO_NUMBER_COUNT;

public enum LottoExceptionMessage {
    LOTTO_WRONG_NUMBER_SIZE("[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT.getSetting() + "개의 번호만을 필요로 합니다."),
    LOTTO_DUPLICATED_NUMBER("[ERROR] 로또 번호의 중복으로 인해 오류가 발생하였습니다."),
    LOTTO_NUMBER_OVER_RANGE("[ERROR] 숫자가 1~45 범위를 넘어 오류가 발생하였습니다.");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
