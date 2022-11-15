package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @DisplayName("로또 순위를 낮은 순위부터 정렬한 랭크 리스트에 대한 테스트")
    @Test
    void sortRank () {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.LOSE_LOTTO);
        ranks.add(Rank.FIFTH_CLASS);
        ranks.add(Rank.FIRTH_CLASS);
        ranks.add(Rank.THIRD_CLASS);
        ranks.add(Rank.SECOND_CLASS);
        ranks.add(Rank.FIRST_CLASS);

        List<Rank> sortRanks = Rank.getSortRanks();

        for (int index = 0; index < sortRanks.size(); index++) {
            assertThat(sortRanks.get(index))
                    .isEqualTo(ranks.get(index));
        }
    }

    @DisplayName("점수에 따른 랭크 값 테스트")
    @Test
    void scoreToRank() {
        Rank rank12 = Rank.findByScore(12);
        Rank rank11 = Rank.findByScore(11);
        Rank rank10 = Rank.findByScore(10);
        Rank rank8 = Rank.findByScore(8);
        Rank rank6 = Rank.findByScore(6);
        Rank rank4 = Rank.findByScore(4);
        Rank rank2 = Rank.findByScore(2);
        Rank rank0 = Rank.findByScore(0);

        assertThat(rank12).isEqualTo(Rank.FIRST_CLASS);
        assertThat(rank11).isEqualTo(Rank.SECOND_CLASS);
        assertThat(rank10).isEqualTo(Rank.THIRD_CLASS);
        assertThat(rank8).isEqualTo(Rank.FIRTH_CLASS);
        assertThat(rank6).isEqualTo(Rank.FIFTH_CLASS);
        assertThat(rank4).isEqualTo(Rank.LOSE_LOTTO);
        assertThat(rank2).isEqualTo(Rank.LOSE_LOTTO);
        assertThat(rank0).isEqualTo(Rank.LOSE_LOTTO);
    }
}
