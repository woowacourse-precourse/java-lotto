package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("로또 맞은 개수 리스트 확인")
    @Test
    void findMatchRankList_1() {
        int bonusNumber = 7;
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(4,5,6,7,8,9)),
                new Lotto(List.of(1,3,5,7,11,12))
        );
        assertThat(Rank.findMatchRank(winningNumbers, lottoList, bonusNumber))
                .isEqualTo(List.of(6,3,3));
    }

    @DisplayName("로또 보너스까지 맞은 개수 리스트 확인")
    @Test
    void findMatchRankList_2() {
        int bonusNumber = 7;
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(4,5,6,7,8,9))
        );
        assertThat(Rank.findMatchRank(winningNumbers, lottoList, bonusNumber))
                .isEqualTo(List.of(7, 3));
    }

    @DisplayName("로또 결과 맵 확인")
    @Test
    void getRankResultMap() {
        List<Integer> matchRank = List.of(2,3,3,6,7);
        Map<Integer, Integer> result = new TreeMap<>(
                Map.of(3,2,6,1,7,1)
        );
        assertThat(Rank.getRankResult(matchRank))
                .isEqualTo(result);
    }
}