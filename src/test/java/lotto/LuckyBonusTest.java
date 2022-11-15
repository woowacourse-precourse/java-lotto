package lotto;

import lotto.model.Lotto;
import lotto.model.LuckyBonus;
import lotto.model.LuckySix;
import lotto.model.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LuckyBonusTest {
    private void validateBonusInclude(int tempLuckyBonus, Lotto luckySix) {
        if (luckySix.isIncludeBonus(tempLuckyBonus)) {
            throw new IllegalAccessError(ErrorMessage.SIX_CONTAIN_BONUS_ERROR_MESSAGE.getMessage());
        }
    }
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByInvalid() {
        assertThatThrownBy(() -> new LuckyBonus("3a", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DIGIT_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("보너스 번호가 1~45사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusByRange() {
        assertThatThrownBy(() -> new LuckyBonus("89", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호 포함되면 예외가 발생한다.")
    @Test
    void createBonusByInclude() {
        assertThatThrownBy(() -> new LuckyBonus("3", new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIX_CONTAIN_BONUS_ERROR_MESSAGE.getMessage());
    }
}