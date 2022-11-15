package lotto.model;

import lotto.Constants;

public enum LottoError {
    PREFIX("[ERROR] "),
    LENGTH(PREFIX.message() + String.format("로또 번호는 %d 개여야 입니다.", Constants.NUMBER_LENGTH)),
    RANGE(PREFIX.message() + String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END)),
    UNIQUE(PREFIX.message() + "로또 번호는 서로 다른 숫자여야 합니다.");
    private final String message;
    LottoError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }

}
