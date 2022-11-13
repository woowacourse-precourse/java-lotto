package lotto.domain;

import lotto.service.CompareLotto;
import lotto.status.lotto.LottoStatus;
import lotto.status.rank.RankMatchStatus;
import lotto.status.rank.RankRewardStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareLottoTest {

    @DisplayName("당첨 결과를 계산한다. 1등일 때")
    @Test
    void compare1() {
        //given
        List<Rank> ranks = RankGenerator.getRanks();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers1 = List.of(1,2,3,4,5,6);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers1, 10);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 1)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank1.getReward());
    }

    @DisplayName("당첨 결과를 계산한다. 2등일 때")
    @Test
    void compare2() {
        //given
        List<Rank> ranks = RankGenerator.getRanks();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers2 = List.of(1,2,3,4,5,9);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers2, 6);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 2)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank2.getReward());
    }
}
