package function;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.LottoVendingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("정상적인 입력")
    @Test
    void correctInput() {
        int lottoTickets = 5;
        assertThat(LottoVendingMachine.getLottos(5).size()).isEqualTo(5);
    }
}
