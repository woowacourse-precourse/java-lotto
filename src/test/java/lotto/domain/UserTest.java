package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자가 올바른 지불금액을 냈는지 확인한다.")
    @Test
    void 유저_금액_입력() {
        User user = new User("2000");

        assertThat(user.getUserPayAmount()).isEqualTo(2000);
    }


    @DisplayName("사용자가 지불금액을 잘못입력하면 예외가 발생한다.")
    @Test
    void 유저_금액_입력_오류() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("1000j"))
                .getMessage().equals("[ERROR] 숫자를 입력해주세요.");
    }

}