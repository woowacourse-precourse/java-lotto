package lotto;

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

    @DisplayName("로또 구입 비용이 1000원단위가 아니면 예외가 발생한다.")
    @Test
    void moneyForLottoDoestHaveRemainder(){
        assertThatThrownBy(() -> Application.countLotto("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 미만 또는 45 초과의 번호가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumbers(){
        assertThatThrownBy(() -> Application.getWinningLotto("1,2,3,4,5,47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
