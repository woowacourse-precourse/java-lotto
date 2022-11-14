package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_값_개수_세기() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 5, 9))).isEqualTo(5);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 4, 8, 9))).isEqualTo(4);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
        assertThat(lotto.countSameNumbers(List.of(1, 2, 10, 7, 8, 9))).isEqualTo(2);
        assertThat(lotto.countSameNumbers(List.of(1, 45, 10, 7, 8, 9))).isEqualTo(1);
    }
}
