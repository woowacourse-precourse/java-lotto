package lotto.model;

import lotto.domain.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("입력된 당첨 번호들 중 1~45 범위를 벗어나는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호_중_범위_벗어난_경우_예외_테스트() {
        List<Integer> numbers = List.of(0,1,2,3,4,5);
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호들 중 중복되는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호_중_중복되는_경우_예외_테스트() {
        List<Integer> numbers = List.of(1,1,2,3,4,5);
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
