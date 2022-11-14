package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.errorenum.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @DisplayName("개별 로또 번호가 범위 내의 숫자가 아니라면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createLottoNumberOutOfRange(int number) {
        assertThatThrownBy(() -> LottoNumberValidator.validateInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.NOT_IN_RANGE.printError());
    }

    @DisplayName("로또의 길이가 6이 아니라면 false 가 반환된다")
    @Test
    void createLottoWithWrongLength() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThat(LottoNumberValidator.isCorrectLength(lotto.size())).isFalse();
    }

    @DisplayName("로또의 길이가 6이 맞다면 true 가 반환된다")
    @Test
    void crateLottoWithRightLength() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        assertThat(LottoNumberValidator.isCorrectLength(lotto.size())).isTrue();
    }

}
