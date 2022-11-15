package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @DisplayName("InputView 는 생성시에 null 이 들어오면 예외가 발생한다")
    @Test
    void InputView_생성자_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new InputView(null));
    }
}
