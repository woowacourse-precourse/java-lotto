package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4,5,6,7), 30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자가 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4,6,6), 30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.");
    }

    @DisplayName("당첨 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfRange() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4,56,6), 30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4,5,6), 70))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedWinningNumbers() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4,5,6), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
    }
}
