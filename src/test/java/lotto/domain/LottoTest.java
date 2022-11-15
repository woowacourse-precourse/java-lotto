package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void checkNumberLength() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR);
    }

    @DisplayName("로또 번호가 1부터 45까지의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void checkNumberRange() {
        assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR),
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining((ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR));
    }
}
