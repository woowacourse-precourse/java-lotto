package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
        void createLottoByShortSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 입력 범위를 벗어나면 예외가 발생한다. (초과시)")
        void createLottoByOutOfRangeNumber1() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호의 입력 범위를 벗어나면 예외가 발생한다. (미달시)")
        void createLottoByOutOfRangeNumber2() {
            assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("정상 동작 테스트")
    class NormalTest {

        @Test
        @DisplayName("로또 번호의 중복이 없고, 6개의 숫자가 들어온다면 정상 동작한다.")
        void createCorrectLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
    }
}
