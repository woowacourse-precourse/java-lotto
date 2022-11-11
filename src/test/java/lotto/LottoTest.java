package lotto;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(
            name = "로또 번호에 1 ~ 45 범위를 벗어난 숫자 " +
                    "EX({argumentsWithNames})가 있으면 예외가 발생한다."
    )
    @ValueSource(ints = {-12, 0, 46, 102})
    void createLottoByOutOfRange(final int number) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 45, number, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
