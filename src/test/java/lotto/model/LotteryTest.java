package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lottery;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class LotteryTest {

    @Test
    void getLotteryList_SetInCorrectSize() {
        Lottery lottery = new Lottery(5);
        List<Lotto> lotteryNumbers = lottery.getLotteryNumbers();
        assertThat(lotteryNumbers.size()).isEqualTo(5);
    }

    @Test
    void getLotteryList_SetInElementOfLotto() {
        Lottery lottery = new Lottery(4);
        List<Lotto> lotteryNumbers = lottery.getLotteryNumbers();
        for (Lotto lotto : lotteryNumbers) {
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
    }
}