package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    @DisplayName("1000원으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void buyLottoByInvalidMoney() {
        Assertions.assertThatThrownBy(() -> new LottoStore(9700))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 부족하여 구매할 수 없을 경우 예외가 발생한다.")
    @Test
    void buyLottoByNoMoney() {
        Assertions.assertThatThrownBy(() -> new LottoStore(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}