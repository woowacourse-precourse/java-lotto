package lotto.ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ValueSource(strings = {"1000", "2000", "10000", "1000000000000"})
    @ParameterizedTest
    void 구매금액은_숫자여야_한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.money()).isEqualTo(Long.parseLong(input));
    }

    @Test
    void 구매금액_앞자리가_0이면_예외가_발생한다() {
        System.setIn(new ByteArrayInputStream("01000".getBytes()));
        assertThatThrownBy(InputView::money)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_음수면_예외가_발생한다() {
        System.setIn(new ByteArrayInputStream("-1".getBytes()));
        assertThatThrownBy(InputView::money)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_숫자가_아니면_예외가_발생한다() {
        System.setIn(new ByteArrayInputStream("가나다라".getBytes()));
        assertThatThrownBy(InputView::money)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1,10,20,30,40,45", "1,3,5,7,9,11"})
    @ParameterizedTest
    void 당첨_번호는_콤마로_구분되는_6개의_숫자여야_한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.winningNumber()).isEqualTo(input);
    }

    @ValueSource(strings = {"1,2", "1,2,3,4,5,6,7", "1,2,3,4,5,06", "1,2,3,4,5,가", "1,,2,3,4,5,6"})
    @ParameterizedTest
    void 당첨_번호가_규칙에_맞지_않으면_예외가_발생한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(InputView::bonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1", "10", "20", "45", "99"})
    @ParameterizedTest
    void 보너스_번호는_한자리_또는_두자리_숫자여야_한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.bonusNumber()).isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"0", "01", "가", "#", "123"})
    @ParameterizedTest
    void 보너스_번호가_한자리_또는_두자리_숫자가_아니면_예외가_발생한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(InputView::bonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
