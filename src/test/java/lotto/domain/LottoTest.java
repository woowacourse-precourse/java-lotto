package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 특정 인덱스의 값을 제대로 얻어오는지 확인한다.")
    @Test
    void getElement() {
        Lotto lotto = new Lotto(List.of(1, 2, 4, 3, 5, 6));
        assert (lotto.get(3) == 3);
    }

    @DisplayName("로또 번호에 특정 숫자가 포함되어 있는지 확인한다.")
    @Test
    void containNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 4, 3, 5, 6));
        assert (lotto.contains(1));
        assert (!lotto.contains(7));
    }
}
