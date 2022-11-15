package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest extends NsTest {

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void createUserByNegative() {
        assertThatThrownBy(() -> new User(-3000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000 미만일 경우 예외가 발생한다.")
    @Test
    void createUserByLackOfAmount() {
        assertThatThrownBy(() -> new User(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞선 테스트에 포함되지 않는 정수가 입력될 경우 정상적으로 클래스가 생성된다.")
    @Test
    void createUser() {
        assertSimpleTest(() -> {
            new User(5000);
        });
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createUserByString_NotNumeric() {
        assertThatThrownBy(() -> new User("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void createUserByString_Negative() {
        assertThatThrownBy(() -> new User("-5000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000 미만일 경우 예외가 발생한다.")
    @Test
    void createUserByString_LackOfAmount() {
        assertThatThrownBy(() -> new User("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞선 테스트에 포함되지 않는 정수가 입력될 경우 정상적으로 클래스가 생성된다.")
    @Test
    void createUserByString() {
        assertSimpleTest(() -> {
            new User("5000");
        });
    }

    @Override
    public void runMain() {

    }
}
