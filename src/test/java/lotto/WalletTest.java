package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WalletTest {
    @DisplayName("0보다 적은 값을 설정하면 오류가 발생한다.")
    @Test
    void setMoneyLowerThanZero() {
        assertThatThrownBy(() -> {
            Wallet wallet = new Wallet();
            wallet.setMoney("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
