package lotto;

public enum LottoConstant {

    LOTTO_START(1),
    LOTTO_END(45),
    LOTTO_NUMBER_COUNT(6);

    public int value;

    LottoConstant(int value) {
        this.value = value;
    }
}
