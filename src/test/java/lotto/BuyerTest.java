package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    @DisplayName("구입 금액이 숫자가 아닐 시 예외 발생")
    @Test
    void inputBuyLottoMoney() {
        assertThatThrownBy(() -> new Buyer().validateBuyLottoMoney("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐시 예외 발생")
    @Test
    void inputBuyLottoMoneyIsNot1000() {
        assertThatThrownBy(() -> new Buyer().validateBuyLottoMoney("2001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액으로 로또 티켓 수 계산")
    @Test
    void calculateLotteryNum() {
        assertThat(new Buyer().calculateLotteryNum(8000)).isEqualTo(8);
    }
}