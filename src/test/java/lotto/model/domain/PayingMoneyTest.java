package lotto.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PayingMoneyTest {
    
    @Test
    void 로또_구입_금액_정상적인_입력값_처리하기() {
        Assertions.assertThatCode(() -> new PayingMoney(" 1 0 0 0 "))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_구입_금액_비정상적인_입력값_처리하기() {
        Assertions.assertThatThrownBy(() -> new PayingMoney("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new PayingMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new PayingMoney("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}