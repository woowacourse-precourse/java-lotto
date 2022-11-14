package lotto.domain;

import lotto.domain.lottoData.Lotto;
import lotto.domain.raffleDevice.RaffleMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RaffleMachineTest {

    RaffleMachine raffleMachine = new RaffleMachine();

    @Test
    void 로또_당첨_숫자_측정() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Integer winnerResult = raffleMachine.countWinner(lotto, winningNumbers, bonusNumber);

        Assertions.assertThat(winnerResult).isEqualTo(1);
    }

}