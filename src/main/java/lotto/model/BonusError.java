package lotto.model;

import lotto.Constants;

public enum BonusError {
    PREFIX("[ERROR] "),
    RANGE(PREFIX.message() + String.format("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END)),
    UNIQUE(PREFIX.message() + "보너스 번호는 로또 번호에 포함되지 않은 숫자여야 합니다.");
    private final String message;
    BonusError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
