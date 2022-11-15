package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinNumbersTest {

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        void createWinNumbersByOverSize() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
        void createWinNumbersByShortSize() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void createWinNumbersByDuplicatedNumber() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호군과 중복되면 예외가 발생한다.")
        void createWinNumbersWithoutBonusNumber() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 입력 범위를 벗어나면 예외가 발생한다. (초과시)")
        void createWinNumbersByOutOfRangeNumber1() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 46), 6))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 입력 범위를 벗어나면 예외가 발생한다. (미달시)")
        void createWinNumbersByOutOfRangeNumber2() {
            assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("정상 동작 테스트")
    class NormalTest {

        @Test
        @DisplayName("로또 번호의 중복이 없고, 6개의 숫자 및 보너스 번호가 들어온다면 정상 동작한다.")
        void createCorrectWinLotto() {
            WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
            assertThat(winNumbers).isInstanceOf(WinNumbers.class);
        }
    }
}
