package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 유효성_검사_예외() {
        List<Integer> only6 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> duplicate = List.of(1, 2, 3, 4, 5, 6, 6);
        List<Integer> over7 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> overValue = List.of(1, 2, 3, 4, 5, 6, 7, 55);
        List<Integer> underValue = List.of(0, 2, 3, 4, 5, 6, 7, 55);

        assertThatThrownBy(() -> new WinningLotto(only6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(duplicate)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(over7)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(overValue)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(underValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeMatchResult() {
    }
}