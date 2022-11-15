package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberBoxTest {
    @Nested
    class WrongWinningNumbers {
        @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
        @Test
        void createNumberBoxByNonSix() {
            assertThatThrownBy(() -> new NumberBox(List.of(1, 2, 3, 4, 5), 6))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
        @Test
        void createNumberBoxByDuplicateNumbers() {
            assertThatThrownBy(() -> new NumberBox(List.of(1, 2, 3, 4, 5, 3), 6))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호가 범위 내에 있지 않는 경우 예외가 발생한다.")
        @Test
        void createNumberBoxByNotInRangeNumbers() {
            assertThatThrownBy(() -> new NumberBox(List.of(1, 2, 3, 4, 5, 120), 6))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class WrongBonusNumber {
        @DisplayName("당첨 번호와 보너스 숫자가 중복되는 경우 예외가 발생한다.")
        @Test
        void createNumberBoxByDuplicateBonusNumber() {
            assertThatThrownBy(() -> new NumberBox(List.of(1, 2, 3, 4, 5, 9), 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 숫자가 범위 내에 있지 않는 경우 예외가 발생한다.")
        @Test
        void createNumberBoxByNotInRangeBonusNumber() {
            assertThatThrownBy(() -> new NumberBox(List.of(1, 2, 3, 4, 5, 9), 112))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
