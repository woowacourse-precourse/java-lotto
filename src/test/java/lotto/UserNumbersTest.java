package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumbersTest {

    @DisplayName("사용자가 형식에 맞지않는 입력형식을 입력하면 예외가 발생한다.")
    @Test
    void wrongUserInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbers("asdas,dqwdl,dq");
        });

    }

    @DisplayName("형식은 맞지만 6자리가 아닌경우 예외가 발생한다.")
    @Test
    void overlengthUserInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(new UserNumbers("1,2,3,4,5,6,7").getNUMBERS());
        });
    }

}
