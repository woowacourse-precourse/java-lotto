package lotto.domain.raffleDevice;

import lotto.domain.Rank;
import lotto.domain.lottoData.Lotto;
import lotto.domain.raffleDevice.RaffleMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RaffleMachineTest {

    RaffleMachine raffleMachine = new RaffleMachine();

    @Test
    void 로또_당첨_숫자_측정() {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> normalNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> winnerPerRank = raffleMachine.getWinnerPerRank(lotto, normalNumbers, bonusNumber);

        Assertions.assertThat(winnerPerRank.get(Rank.FIRST)).isEqualTo(1);
    }



}