package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("두 로또를 비교해서 공통 번호의 개수를 구한다.")
    @Test
    void compare() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto other = new Lotto("4,5,6,10,15,20");

        assertThat(lotto.compare(other)).isEqualTo(3);
    }

    @DisplayName("로또에 특정 번호가 포함되는지 여부를 반환한다.")
    @CsvSource(value = {"1:true", "10:false"}, delimiter = ':')
    @ParameterizedTest
    void contains(int bonus, boolean expected) {
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.contains(bonus)).isEqualTo(expected);
    }
}
