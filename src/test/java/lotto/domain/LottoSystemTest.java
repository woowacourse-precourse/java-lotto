package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSystemTest {

    @DisplayName("로또 시스템에 1000원 단위의 금액이 입력된 경우의 로또 구매 횟수 확인")
    @Test
    void 로또_시스템_금액_확인() {
        User user = new User("2000");
        LottoSystem lottoSystem = new LottoSystem(user);
        lottoSystem.setUserLottoCount();
        assertThat(lottoSystem.getUserLottoCount()).isEqualTo(2);
    }

    @DisplayName("로또 시스템에 1000원 단위의 금액이 입력되지 않은 경우")
    @Test
    void 로또_시스템_금액_에러() {
        User user = new User("2345");

        assertThrows(IllegalArgumentException.class,
                () -> new LottoSystem(user))
                .getMessage().equals("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
    }

}