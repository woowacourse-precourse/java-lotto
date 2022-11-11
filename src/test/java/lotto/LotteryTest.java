package lotto;

import lotto.domain.Lottery;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    void createLottos() {
        List<Lotto> expected = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        ConstantCreateStrategy testStrategy = new ConstantCreateStrategy();
        int buyLottos = 2;

        List<Lotto> lottos = new Lottery().createLottery(buyLottos, testStrategy);

        assertThat(lottos).isEqualTo(expected);
    }

}
