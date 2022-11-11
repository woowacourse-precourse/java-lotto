package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private List<Integer> lottoNumbers;

    @BeforeEach
    private void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 범위_외_보너스번호_예외_테스트() {
        int bonusNumber = 47;
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningLotto.NUMBER_INPUT_RANGE_ERROR_MESSAGE);
    }

    @Test
    void 중복되는_보너스_번호_예외_테스트() {
        int bonusNumber = 4;
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningLotto.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
}