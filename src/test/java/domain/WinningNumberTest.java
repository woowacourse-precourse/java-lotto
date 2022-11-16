package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    @DisplayName("보너스 번호가 범위를 벗어난 경우")
    @Test
    void incorrectBonusNumberRange() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 46;
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 경우")
    @Test
    void duplicateNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}