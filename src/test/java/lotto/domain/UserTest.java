package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
