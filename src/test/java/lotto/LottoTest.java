package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액의 단위가 1000원이 아니면 예외가 발생한다.")
    @Test
    void buyLottoNotUnit1000Won() {
        assertThatThrownBy(() -> Lotto.calculate("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0으로 시작하면 예외가 발생한다.")
    @Test
    void buyLottoStartZero() {
        assertThatThrownBy(() -> Lotto.checkIsInt("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 있으면 예외가 발생한다.")
    @Test
    void buyLottoNotInteger() {
        assertThatThrownBy(() -> Lotto.checkIsInt("1200k"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
