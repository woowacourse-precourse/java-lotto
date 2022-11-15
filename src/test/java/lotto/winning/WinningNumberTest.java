package lotto.winning;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.DuplicatedBonusNumberException;
import lotto.exception.IllegalLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호를 정상적으로 생성한다.")
    @Test
    public void constructorSuccessTest() throws Exception {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when

        // then
        assertThatCode(() -> new WinningNumber(numbers, bonusNumber)).doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호의 범위를 넘으면 예외가 발생한다.")
    @Test
    public void constructorRangeFailTest() throws Exception {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 0;

        // when

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonusNumber)).isInstanceOf(
                IllegalLottoNumberRangeException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    public void constructorDuplicatedFailTest() throws Exception {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;

        // when

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonusNumber)).isInstanceOf(
                DuplicatedBonusNumberException.class
        );
    }
}