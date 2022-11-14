package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    final static private int lottoSize = 6;

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7), lottoSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), lottoSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("요구사항 범위보다 큰 테스트")
    @Test
    void maxOverFlowNumber() {
        List<Integer> expect = List.of(1, 2, 3, 4, 46, 5);
        assertThatThrownBy(() -> new Lotto(expect, lottoSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("요구사항 범위보다 적은 테스트")
    @Test
    void minOverFlowNumber() {
        List<Integer> expect = List.of(0, 2, 3, 4, 6, 5);
        assertThatThrownBy(() -> new Lotto(expect, lottoSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
