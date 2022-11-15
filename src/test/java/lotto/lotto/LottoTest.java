package lotto.lotto;

import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.IllegalLottoLengthException;
import lotto.exception.IllegalLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호를 정상적으로 생성한다.")
    @Test
    public void constructorSuccessTest() throws Exception {
        // given
        List<Integer> numbers = List.of(3, 7, 13, 23, 37, 45);

        // when

        // then
        assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalLottoLengthException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicatedLottoNumberException.class);
    }

    @DisplayName("로또 번호의 범위를 넘으면 예외가 발생한다.")
    @Test
    public void constructorRangeFailTest() throws Exception {
        // given
        List<Integer> numbers = List.of(3, 7, 13, 23, 37, 46);

        // when

        // then
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalLottoNumberRangeException.class);
    }
}
