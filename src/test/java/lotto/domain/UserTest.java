package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("금액이 숫자로만 이루어져 있지 않다면 예외가 발생한다.")
    @Test
    void createBuyAmountByWrongForm() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount("1asd"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
