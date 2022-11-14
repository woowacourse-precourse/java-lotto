package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위에 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 로또 번호에 포함되어이 있는지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "7, false"})
    void containsTrueTest(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean actual = lotto.contains(number);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다른 로또 객체와 비교하여 같은 숫자가 몇개인지 검사한다.")
    @Test
    void countSameNumberTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        assertThat(lotto1.countSameNumber(lotto2)).isEqualTo(1);
    }
}
