package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void validateDuplicateNumber() {
    }

    @Test
    void calculateRank() {
    }

    @DisplayName("당첨번호와 보너스 번호가 같으면 예외가 발생한다.")
    @Test
    void valueOf() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}