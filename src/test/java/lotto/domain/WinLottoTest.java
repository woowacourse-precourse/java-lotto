package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @DisplayName("보너스 번호가 범위를 초과하면 예외가 발생한다.")
    @Test
    void bonusNumberByExcessRange() {
        WinLotto winLotto = new WinLotto();
        int input = 50;
        assertThatThrownBy(() -> winLotto.validateBonusNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호 중 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoBonusByDuplicatedNumber() {
        WinLotto winLotto = new WinLotto();
        assertThatThrownBy(() ->winLotto.validateDuplicateBonusNumber(4,List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}