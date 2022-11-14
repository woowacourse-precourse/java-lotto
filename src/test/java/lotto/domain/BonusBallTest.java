package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import constants.ExceptionMessage;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallTest {

    @DisplayName("보너스 번호가 1 ~ 45 범위에 해당하지 않으면 예외 발생")
    @Test
    void createBonusNumberNotWithinRange() {
        int number = 46;

        assertThatThrownBy(() -> new BonusBall(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WITHIN_RANGE);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위에 해당하면 정상 진행")
    @Test
    void createBonusNumberWithinRange() {
        int number = 32;

        assertThatCode(() -> new BonusBall(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 보너스 번호가 존재하는 경우")
    @Test
    void createBonusNumberIncludedInLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(1);

        boolean isContains = bonusBall.isMatchLotto(lotto);

        assertTrue(isContains);
    }

    @DisplayName("로또 번호에 보너스 번호가 존재하지 않는 경우")
    @Test
    void createBonusNumberNotIncludedInLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);

        boolean isContains = bonusBall.isMatchLotto(lotto);

        assertFalse(isContains);
    }


}