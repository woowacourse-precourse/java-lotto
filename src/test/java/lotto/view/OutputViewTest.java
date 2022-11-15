package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutputViewTest {
    @DisplayName("OutputView 가 생성될 때 null 이 들어오면 예외가 발생한다")
    @Test
    void OutputView_생성자_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new OutputView(null));
    }
}
