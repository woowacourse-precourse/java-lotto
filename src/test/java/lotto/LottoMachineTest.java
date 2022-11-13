package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private static final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 입력받은_금액만큼_로또를_생성합니다() {
        String testInput = "8000";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        lottoMachine.receiveMoney();
        lottoMachine.createLottoTickets();
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();

        Assertions.assertThat(lottoTickets.size()).isEqualTo(8);
    }

}
