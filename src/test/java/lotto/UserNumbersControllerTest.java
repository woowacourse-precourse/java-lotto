package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
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
            new UserNumbersController("asdas,dqwdl,dq", "1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbersController("1,2,3,4,5,6", "1g");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbersController("1,2,3,4,5,6", "1 2");
        });
    }

    @DisplayName("형식은 맞지만 6자리가 아닌경우 예외가 발생한다.")
    @Test
    void overlengthUserInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserNumbersController("1,2,3,4,5,6,7", "1").getNUMBERS();
        });
    }

    @DisplayName("입력한 로또 번호가 정렬됬는지 테스트")
    @Test
    void orderbylottonumbers() {
        UserNumbersController userNumbersController = new UserNumbersController("1,3,4,6,2,5", "7");
        assertThat(userNumbersController.getNUMBERS().getNumbers()).isEqualTo(
            List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 맞게 저장됬는지 테스트")
    @Test
    void bonusnumbercheck() {
        UserNumbersController userNumbersController = new UserNumbersController("1,3,4,6,2,5", "7");
        assertThat(userNumbersController.getBONUS_NUMBER()).isEqualTo(7);
    }


}
