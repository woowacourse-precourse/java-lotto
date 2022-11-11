package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import lotto.controller.UserNumbersController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumbersControllerTest {

    @DisplayName("사용자가 형식에 맞지않는 입력형식을 입력하면 예외가 발생한다.")
    @Test
    void wrongUserInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbersController("asdas,dqwdl,dq","1");
        });

    }

    @DisplayName("형식은 맞지만 6자리가 아닌경우 예외가 발생한다.")
    @Test
    void overlengthUserInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbersController("1,2,3,4,5,6,7","1").getNUMBERS();
        });
    }

}
