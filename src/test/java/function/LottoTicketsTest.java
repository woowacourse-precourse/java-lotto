package function;

import lotto.LottoVendingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("정상적인 입력")
    @Test
    void correctInput() {
        int purchaseAmount = 5000;
        assertThat(LottoVendingMachine.getLottoTickets(5000)).isEqualTo(5);
    }
}
