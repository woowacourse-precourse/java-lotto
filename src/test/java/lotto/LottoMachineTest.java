package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    public static final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구매한 로또 개수 확인")
    @Test
    void 구매한_로또_개수() {
        int input = 8000;
        int lottoCnt = lottoMachine.getLottoBuyCount(input);
        assertThat(lottoCnt).isEqualTo(input / LottoInfo.PRICE.getValue());
    }
}