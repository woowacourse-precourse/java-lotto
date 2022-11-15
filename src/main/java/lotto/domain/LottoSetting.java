package lotto.domain;

public enum LottoSetting {
    CASH_UNIT(1000),
    CASH_ZERO(0),
    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int setting;

    LottoSetting(int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
