package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class UserTest {
    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    User user = new User();

    @Test
    void 금액입력시_올바른_횟수_출력() {
        systemIn("1000");
        user.getBudget();
        assertThat(user.getPublicans()).isEqualTo(1);

        systemIn("1001");
        assertThatThrownBy(() -> user.getBudget()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위입니다!");
    }

    @Test
    void 숫자6개_입력시_올바른_validation() {
        systemIn("1,2,3,4");
        assertThatThrownBy(() -> user.getNumbers()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력해주세요!");

        systemIn("1,2,3,4,k,7");
        assertThatThrownBy(() -> user.getNumbers()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요!");

        systemIn("1,2,3,4,66,67");
        assertThatThrownBy(() -> user.getNumbers()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45사이의 숫자를 입력해주세요!");

        systemIn("1,2,3,4,4,4");
        assertThatThrownBy(() -> user.getNumbers()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 서로 다른 숫자를 입력해주세요!");

    }

    @Test
    void 보너스번호_입력_처리테스트() {
        systemIn("1");
        user.getBonusNumber();
        assertThat(user.getBonus()).isEqualTo(1);

        systemIn("k");
        assertThatThrownBy(() -> user.getBonusNumber()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요!");
    }

}