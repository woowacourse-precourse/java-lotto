package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.errorenum.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 당첨 로또 번호와 중복되는 경우 오류가 발생한다")
    @Test
    void createBonusNumberWithDuplication() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.BONUS_NUMBER_DUPLICATE.printError());
    }

    @DisplayName("보너스 번호가 로또 숫자 범위에서 벗어나는 경우 오류가 발생한다")
    @Test
    void createBonusNumberOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.NOT_IN_RANGE.printError());
    }

}
