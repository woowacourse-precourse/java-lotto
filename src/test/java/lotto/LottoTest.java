package lotto;

import lotto.model.Lotto;
import lotto.utils.Rules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 개수가 6개가 안되면 예외 테스트")
    @Test
    void createLottoUnderSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위가 1~45를 벗어날 때 예외 테스트")
    @Test
    void createLottoRangeNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 index로 값 가져오는 테스트")
    @Test
    void findLottoNumberByIndexTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int index = 0;
        int target = 1;
        assertThat(lotto.findLottoNumber(index)).isEqualTo(target);
    }

    @DisplayName("로또 번호가 포함되어있는지 확인하는 테스트")
    @Test
    void containNumberLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        for (int number = 1; number <= 6; number++) {
            assertThat(lotto.containNumber(number)).isEqualTo(true);
        }
    }
}
