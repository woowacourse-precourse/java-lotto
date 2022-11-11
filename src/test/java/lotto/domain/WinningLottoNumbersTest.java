package lotto.domain;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoNumbersTest {
    public static final WinningLottoNumbers WINNING_LOTTO_NUMBERS;
    
    static {
        WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, 7);
    }
    
    @Test
    @DisplayName("올바른 당첨 번호 및 보너스 번호 입력 시")
    void correctWinningLotto() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, 7));
    }
    
    @Test
    @DisplayName("예외 처리 : 로또 번호의 개수가 6개가 넘어갈 시")
    void createLottoByOverSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 8))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 로또 번호에 중복된 숫자가 있을 시")
    void createLottoByDuplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 5)), 8))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 6개의 숫자 중, 1~45 범위를 벗어난 숫자가 존재하는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void lottoOutOfRangeException(final int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(new Lotto(List.of(1, 2, 3, 4, 5, lottoNumber)), 8))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 보너스 번호가 1~45 의 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void bonusNumberOutOfRangeException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, bonusNumber))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 중복되는 번호가 있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 6})
    void duplicateLottoNumberException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, bonusNumber))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("매칭되는 번호 개수 구하기")
    void numberOfMatchingNumbers() {
        assertThat(WINNING_LOTTO_NUMBERS.countOfMatchingNumber(LottoTest.FROM_ONE_TO_SIX)).isEqualTo(6);
    }
    
    @Test
    @DisplayName("보너스 번호가 매칭되는지 확인하기")
    void isBonusNumberExist() {
        assertThat(WINNING_LOTTO_NUMBERS.isBonusNumberExist(LottoTest.FROM_ONE_TO_SIX)).isFalse();
        assertThat(WINNING_LOTTO_NUMBERS.isBonusNumberExist(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isTrue();
    }
}