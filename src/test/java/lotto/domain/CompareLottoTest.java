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
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers, 10);
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
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers, 6);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 2)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank2.getReward());
    }

    @DisplayName("당첨 결과를 계산한다. 3등일 때")
    @Test
    void compare3() {
        //given
        List<Rank> ranks = RankGenerator.getRanks();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers, 45);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 3)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank3.getReward());
    }

    @DisplayName("당첨 결과를 계산한다. 4등일 때")
    @Test
    void compare4() {
        //given
        List<Rank> ranks = RankGenerator.getRanks();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers2 = List.of(1,2,3,4,8,9);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers2, 6);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 4)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank4.getReward());
    }

    @DisplayName("당첨 결과를 계산한다. 5등일 때")
    @Test
    void compare5() {
        //given
        List<Rank> ranks = RankGenerator.getRanks();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        List<Integer> winningNumbers2 = List.of(1,2,3,7,8,9);
        //when
        CompareLotto.compare(ranks, lottos, winningNumbers2, 6);
        //then
        assertThat(ranks.stream()
                .filter(r -> r.getRanking() == 5)
                .findFirst().get()
                .getTotalReward())
                .isEqualTo(RankRewardStatus.rank5.getReward());
    }
}
