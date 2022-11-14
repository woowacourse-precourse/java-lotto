package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("숫자가 아닌 것을 입력하면 예외가 발생한다.")
    @Test
    void inputByNotNumber() {
        assertThatThrownBy(() -> new User("ABC"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 것을 입력하면 예외가 발생한다.")
    @Test
    void inputByNotDividedBy1000() {
        assertThatThrownBy(() -> new User("15001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
