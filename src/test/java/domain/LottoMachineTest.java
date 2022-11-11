package domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest {

    @Test
    @DisplayName("로또 구입 시 로또 구입 개수는 금액과 비례한다.")
    public void 구매_로또_리스트_생성() throws Exception {
        //given
        int money = 5000;
        LottoMachine machine = new LottoMachine(money);
        
        //when
        List<Lotto> lottos = machine.buyTickets();

        //then
        assertThat(lottos.size()).isEqualTo(5);
    }
}