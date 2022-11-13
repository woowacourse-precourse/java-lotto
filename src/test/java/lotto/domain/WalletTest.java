package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {

    @DisplayName("구입 금액을 입력받아 구매 가능한 로또 티켓의 수를 반환한다")
    @Test
    void calculate_Maximum_Number_Of_LottoTickets_Can_Purchase_Test() {
        // given
        Wallet wallet = new Wallet(5000);

        // when
        int countOfTickets = wallet.calculate();

        // then
        assertThat(countOfTickets).isEqualTo(5);
    }

}
