package lotto.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserMoneyTest {
    private static final String ERROR = "[ERROR]";

    @DisplayName("로또구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByWrongUnits() {
        // given
        String userAmount = "1200";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when then
        assertThatThrownBy(User::buyLotto)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}
