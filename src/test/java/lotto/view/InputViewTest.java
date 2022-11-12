package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("숫자가 아닌 값 입력한 경우 예외가 발생한다.")
    void inputValueByNonNumericValue() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.validateValue("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}