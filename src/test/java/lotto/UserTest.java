package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest extends NsTest {

    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void isNumeric() {
        assertThatThrownBy(() -> {
            User user = new User();
            command("asdf");
            user.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void isCorrectPrice() {
        assertThatThrownBy(() -> {
            User user = new User();
            command("1500");
            user.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
