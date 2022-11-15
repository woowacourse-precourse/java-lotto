package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    public void createPlayerByOverSize() {
        assertThatThrownBy(() -> new Computer(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createPlayerByDuplicatedNumber() {
        assertThatThrownBy(() -> new Computer(List.of(1, 2, 3, 4, 5, 5), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자가 1~45 범위를 넘으면 예외가 발생한다.")
    @Test
    public void createPlayerByOverRange() {
        assertThatThrownBy(() -> new Computer(List.of(1, 2, 3, 46, 5, 5), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 숫자가 1~45 범위를 넘으면 예외가 발생한다.")
    @Test
    public void createPlayerByOverRangeBonusNumber() {
        assertThatThrownBy(() -> new Computer(List.of(1, 2, 3, 4, 5, 5), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}