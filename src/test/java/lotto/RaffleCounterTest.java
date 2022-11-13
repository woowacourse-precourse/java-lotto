package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaffleCounterTest {

    RaffleCounter raffleCounter = new RaffleCounter();

    @Test
    void 로또_당첨_숫자_측정() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> winnerResult = raffleCounter.countWinner(lotto, winningNumbers, bonusNumber);

        Assertions.assertThat(winnerResult).isEqualTo(List.of(6, 0));
    }

}