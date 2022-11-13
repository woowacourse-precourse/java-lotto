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

    @DisplayName("금액의 첫부분이 0으로 시작하면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        User user = new User();
        assertThatThrownBy(() -> user.setBuyAmount("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
