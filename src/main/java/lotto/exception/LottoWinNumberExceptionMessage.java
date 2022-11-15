package lotto.exception;

import static lotto.domain.LottoSetting.LOTTO_NUMBER_COUNT;

public enum LottoWinNumberExceptionMessage {
    LOTTO_NUMBER_OVER_RANGE("[ERROR] 숫자가 1~45 범위를 넘어 오류가 발생하였습니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 번호의 중복으로 인해 오류가 발생하였습니다."),
    LOTTO_NUMBER_WRONG_SIZE("[ERROR] 로또 번호의 개수가 " + LOTTO_NUMBER_COUNT.getSetting() + "개와 같지 않아 오류가 발생하였습니다.");

    private final String message;

    LottoWinNumberExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
