package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {

    @DisplayName("구입 금액을 입력받아 구매 가능한 로또 티켓의 수를 반환한다")
    @Test
    void calculateMaximumNumberOfLottoTicketsCanPurchase() {
        // given
        Wallet wallet = new Wallet(5000);

        // when
        int countOfTickets = wallet.calculate();

        // then
        assertThat(countOfTickets).isEqualTo(5);
    }

    @DisplayName("구입 금액이 티켓 가격보다 작은 경우 예외가 발생하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -500, 0, 1, 100})
    void checkNormalAmount(int money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 구입 금액이 티켓 가격보다 작습니다.");
    }

    @DisplayName("구입 금액이 티켓 가격으로 나누어 떨어지지 않는 경우 예외가 발생하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2500, 55555})
    void checkMoneyDivisibleByTicketPrice(int money) {
        assertThatThrownBy(() -> new Wallet(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액이 티켓 가격으로 나누어 떨어지지 않습니다.");
    }
}
