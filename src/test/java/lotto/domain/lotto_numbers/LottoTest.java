package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.Lotto.INVALID_RANGE_OF_LOTTO_NUMBER;
import static lotto.domain.lotto_numbers.Lotto.INVALID_SIZE_OF_LOTTO_NUMBERS;
import static lotto.domain.lotto_numbers.Lotto.NOT_ALLOW_DUPLICATED_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SIZE_OF_LOTTO_NUMBERS);  // TODO 혹시 제출 안되면 여기 의심
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
    }

    @ParameterizedTest(name = "로또 번호가 1~45가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void createLottoByNumberHasInvalidRange(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(invalidNumber, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_OF_LOTTO_NUMBER);
    }
}
