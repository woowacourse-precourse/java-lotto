package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("구입금액 5000원이 money에 저장됐는지 테스트")
    @Test
    void inputBuyLottoPrice() {
        //given
        final int money = 5000;
        final User user = new User();
        //when
        systemIn(String.valueOf(money));
        user.inputBuyLottoPrice();
        //given
        assertThat(money).isEqualTo(user.getMoney());
    }

    @DisplayName("구입금액이 숫자 입력이 아닐 때 예외처리 테스트")
    @Test
    void inputNotNumberException() {
        //given
        final User user = new User();
        //when
        systemIn("abcd");
        //given
        assertThatThrownBy(user::inputBuyLottoPrice)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 단위가 아닐 때 예외처리 테스트")
    @Test
    void inputNotDivided1000() {
        //given
        final User user = new User();
        //when
        systemIn("1111");
        //given
        assertThatThrownBy(user::inputBuyLottoPrice)
                .isInstanceOf(IllegalArgumentException.class);
    }
}