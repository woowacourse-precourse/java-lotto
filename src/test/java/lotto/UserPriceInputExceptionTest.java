package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.UserPriceInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserPriceInputExceptionTest {

    private UserPriceInputException userPriceInputException = new UserPriceInputException();

    @Test
    @DisplayName("유저 입력은 숫자로만 이루어져야 한다")
    void userPriceInputConsistOfNumber() {
        assertThatThrownBy(
                () -> userPriceInputException.isUserPriceValid("1a2d")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저 입력은 1000원 단위로 이루어져야 한다")
    void userPriceInputConsistOfThousand() {
        assertThatThrownBy(
                () -> userPriceInputException.isUserPriceValid("3300")).isInstanceOf(
                IllegalArgumentException.class);
    }
}
