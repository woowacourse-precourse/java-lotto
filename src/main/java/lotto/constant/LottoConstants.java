package lotto.constant;

/**
 * 로또 시스템 전체에서 사용되는 상수를 관리합니다
 */
public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_START_INCLUSIVE(1),
    LOTTO_END_INCLUSIVE(45),
    LOTTO_LENGTH(6);


    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    /**
     * 상수 식별자로부터 실제 값을 가져옵니다
     *
     * @return 상수에 해당하는 int 숫자
     */
    public int value() {
        return this.value;
    }
}
