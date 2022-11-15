package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createLotto(int input) {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.getNumbers()).contains(LottoNumber.of(input));
    }

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

    @DisplayName("몇 개의 숫자를 맞췄는지 반환한다.")
    @Test
    void countMatchNumber() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winningLotto = new Lotto("1,2,3,7,8,9");

        assertThat(winningLotto.countMatchNumber(lotto)).isEqualTo(3);
    }
}
