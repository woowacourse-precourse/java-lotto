package domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest {

    @Test
    @DisplayName("로또 구입 시 로또 구입 개수는 금액과 비례한다.")
    public void 구매_로또_리스트_생성() throws Exception {
        //given
        String input = "5000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoMachine machine = new LottoMachine();
        
        //when
        List<Lotto> lottos = machine.buyTickets();

        //then
        assertThat(lottos.size()).isEqualTo(5);
    }
}