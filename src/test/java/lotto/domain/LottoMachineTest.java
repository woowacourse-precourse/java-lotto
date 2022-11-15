package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    @DisplayName("로또 수량 확인")
    @Test
    void toAmount() {
        LottoMachine lottoMachine = new LottoMachine();
        int result = lottoMachine.toAmount(20000);

        assertThat(result).isEqualTo(20);
    }

    @DisplayName("잘못된 금액일경우 예외발생")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {15500, 900, 0})
    void toAmountButException(int money) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.toAmount(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 확인")
    @Test
    void purchaseLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.purchaseLottoTable(5000);
        assertThat(lottoMachine.getLottoTable().size()).isEqualTo(5);
    }
}
