package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void getInputByNonNumeric() {
        assertThatThrownBy(() -> new InputView().validateNumeric("-10000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호에 숫자와 구분자(,) 외 다른 입력이 들어오면 예외가 발생한다.")
    @Test
    void getInputByUnValidSeparator() {
        assertThatThrownBy(() -> new InputView().validateSeparator("1,#,4,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자와 구분자(,)만 입력될 수 있습니다.");
    }
}