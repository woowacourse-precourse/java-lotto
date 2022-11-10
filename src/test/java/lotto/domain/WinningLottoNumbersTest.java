package lotto.domain;

public class WinningLottoNumbersTest {
    public static final WinningLottoNumbers WINNING_LOTTO_NUMBERS;
    
    static {
        WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, 7);
    }
}