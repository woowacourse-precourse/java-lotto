package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 로또_구입_금액이_1000원_미만일_경우_IllegalArugmentException을_반환한다() {
        int money = 900;
        assertThatThrownBy(() -> lottoMachine.insert(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.AMOUNT_IS_NOT_UNDER_1000_MESSAGE);
    }

    @Test
    void 로또_구입_금액이_3000원인_경우_로또_개수_3개를_반환한다() {
        int money = 3000;
        assertThat(lottoMachine.insert(money)).isEqualTo(3);
    }

    @Test
    void 로또_구입_금액이_1500원인_경우_로또_개수_1개를_반환한다() {
        int money = 1500;
        assertThat(lottoMachine.insert(money)).isEqualTo(1);
    }
}