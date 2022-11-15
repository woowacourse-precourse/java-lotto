package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoNotRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 49, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자 리스트를 보내면 Lotto에 저장한다")
    @Test
    void createLottoList() {
        List<Integer> test = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(test);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
