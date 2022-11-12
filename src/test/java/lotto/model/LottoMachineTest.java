package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine();

    @Nested
    @DisplayName("발행할 로또 수량은 로또 한 장의 가격을 나눈 값이다.")
    class CountLottoTicketsTest {
        @Test
        void 로또_수량_테스트_1() {
            assertThat(lottoMachine.countLottoTickets(8000)).isEqualTo(8);
        }

        @Test
        void 로또_수량_테스트_2() {
            assertThat(lottoMachine.countLottoTickets(14000)).isEqualTo(14);
        }
    }
}