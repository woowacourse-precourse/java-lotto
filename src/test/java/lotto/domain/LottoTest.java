package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 생성 검증 테스트")
    @Test
    void createLotto() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.get()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByLesserSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 크거나 1보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 99})
    void createLottoByGreaterThanMaxOrLesserThanMin(int input) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, input)))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
