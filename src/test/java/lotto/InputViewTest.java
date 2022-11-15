package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void getInputByNonNumeric() {
        assertThatThrownBy(() -> new InputView().validate("-10000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 숫자만 가능합니다.");
    }
}
