package lotto;

public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String LOTTO_NUMBER_IS_OUT_OF_RANGE = "[ERROR] 로또 번호가 범위(1~45) 밖에 있습니다.";
    private final int lottoNumber;

    public LottoNumber(int number) {
        validateLottoNumberSize(number);
        this.lottoNumber = number;
    }

    private void validateLottoNumberSize(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_OUT_OF_RANGE);
        }
    }
}
