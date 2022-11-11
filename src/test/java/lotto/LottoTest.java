package lotto;

import lotto.domain.Lotto;
import lotto.utils.ExceptionType;
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
                .hasMessage(ExceptionType.OVER_THAN_NUMBER_OF_LOTTO.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_OVERLAP.getMessage());
    }

    @DisplayName("입력된 로또 번호가 로또 숫자의 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 80)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호가 로또 숫자의 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void addBonusNumberByOverRange() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThatThrownBy(() -> lotto.addNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
    }



}
