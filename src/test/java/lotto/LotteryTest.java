package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    void createLottos() {
        int buyLottos = 5;
        List<Lotto> lottos = new Lottery().createLottos(buyLottos);

        assertThat(lottos.size()).isEqualTo(buyLottos);
    }
}
