package lotto;

import lotto.logic.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 6자리가 아니면 예외 발생")
    @Test
    void checkvalidate() {
        assertThatThrownBy(()->new Lotto(List.of(1, 2, 2, 3, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
