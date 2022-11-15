package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("돈이 양수가 아니면 예외가 발생한다.")
    @Test
    void createUserByMoneyNotPositive() {
        assertThatThrownBy(() -> new User(-1000))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createUserByMoneyNotMultiple1000() {
        assertThatThrownBy(() -> new User(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 1000의 배수인 양수인 경우 정상 실행된다.")
    @Test
    void createUserByAppropriateMoney() {
        assertThatNoException().isThrownBy(() -> new User(1000));

        User user= new User(1000);
        assertThat(user.getLottos().size()).isEqualTo(1);
    }

}
