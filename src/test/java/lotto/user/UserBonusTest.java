package lotto.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.user.validation.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserBonusTest {
    @DisplayName("보너스를 숫자로 입력하지 않으면 예외가 발생한다.")
    @Test
    void InputBonusByNotNumber() {
        // given
        String userAmount = "이";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when then
        assertThatThrownBy(User::inputBonusNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.ONLY_NUMBER.toString());
    }
}
