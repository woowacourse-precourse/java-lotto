package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("구매 금액을 입력받아서 로또 구매 후 로또 개수 확인하는 테스트")
    void buyLottoTest() {
        int money = 5000;
        int expected = 5;

        User user = User.initUserLotto(money);

        Assertions.assertThat(user.getLottoCount()).isEqualTo(expected);
        Assertions.assertThat(user.getLottos().size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("1000원 이하 구매 금액 입력 테스트")
    void minimumMoneyTest() {
        int money = 500;

        assertThatThrownBy(() -> User.initUserLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않는 구매 금액 입력 테스트")
    void dividedMoneyTest() {
        int money = 2500;

        assertThatThrownBy(() -> User.initUserLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
