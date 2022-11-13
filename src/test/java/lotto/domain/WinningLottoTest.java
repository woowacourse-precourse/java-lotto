package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 보너스_번호_숫자_아닐_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_시_예외_처리() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 1, 2, 3, 4, 5), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
