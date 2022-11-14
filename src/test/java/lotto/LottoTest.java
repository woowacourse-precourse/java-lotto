package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 수가 아니면 예외 발생")
    @Test

    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 로또 번호 입력 테스트")
    @Test

    void createLotto() {
        assertThat(new Lotto(List.of(1,2,3,4,5,6)).getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
