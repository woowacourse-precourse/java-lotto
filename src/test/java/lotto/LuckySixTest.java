package lotto;

import lotto.model.LuckySix;
import lotto.model.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LuckySixTest {
    @DisplayName("당첨 번호가 올바른 입력이 아닐 때")
    @Test
    void createLuckySixByInvalid() {
        assertThatThrownBy(() -> new LuckySix("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIX_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호가 6개가 아닐 때")
    @Test
    void createLuckySixByOverSize() {
        assertThatThrownBy(() -> new LuckySix("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LENGTH_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호의 번호가 지정 범위를 벗어날 때")
    @Test
    void createLuckySixByOutRange() {
        assertThatThrownBy(() -> new LuckySix("1,2,3,4,5,67"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("당첨 번호끼리 중복될 때")
    @Test
    void createLuckySixByDuplicatedNumber() {
        assertThatThrownBy(() -> new LuckySix("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getMessage());
    }
}