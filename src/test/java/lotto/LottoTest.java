package lotto;

import lotto.model.Lotto;
import lotto.model.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LENGTH_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호의 범위가 1 미만 45 초과이면 예외가 발생한다.")
    @Test
    void createLottoByOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
    }
}
