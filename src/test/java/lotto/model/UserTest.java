package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("수량만큼 로또 생성 및 추가")
    @Test
    void add_lotto() {
        User user = new User();
        user.addRandomLotto(5);
        assertThat(user.getLottoQuantity()).isEqualTo(5);
    }

    @DisplayName("수익율 계산")
    @Test
    void get_profit_rage(){
        User user = new User();
        user.addMoney(10000);

    }
}
