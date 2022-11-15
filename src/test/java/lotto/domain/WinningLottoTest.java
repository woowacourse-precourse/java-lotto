package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private List<Integer> lottoNumbers;

    @BeforeEach
    private void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("1~45외 보너스번호 입력시 예외 발생 테스트")
    @Test
    void createWinningLottoByBonusNumberOutOfRange() {
        int bonusNumber = 47;
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningLotto.NUMBER_INPUT_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("중복되는 보너스 번호 입력시 예외 발생 테스트")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        int bonusNumber = 4;
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningLotto.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
}