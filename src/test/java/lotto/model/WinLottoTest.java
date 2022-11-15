package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    public void 당첨로또번호_정상() {
        assertThatCode(() -> new WinLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7)
        ).doesNotThrowAnyException();
    }

    @Test
    public void 당첨로또번호_보너스값중복() {
        assertThatThrownBy(() -> new WinLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                6)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}