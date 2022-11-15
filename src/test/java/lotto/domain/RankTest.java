package lotto.domain;

import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("초기 랭크리스트 생성갯수 예외 발생")
    @Test
    void 초기_랭크리스트_생성갯수_예외발생() {
        assertThat(Rank.getRanks().size()).isEqualTo(5);
    }

    @DisplayName("초기 랭크리스트 생성 초기값 예외 발생")
    @Test
    void 초기_랭크리스트_생성_초기값_예외발생() {
        List<Rank> ranks = Rank.getRanks();
        assertThat(ranks.get(0).getRanking()).isEqualTo(5);
        assertThat(ranks.get(0).getReward()).isEqualTo(5000l);
        assertThat(ranks.get(1).getRanking()).isEqualTo(4);
        assertThat(ranks.get(1).getReward()).isEqualTo(50000l);
        assertThat(ranks.get(2).getRanking()).isEqualTo(3);
        assertThat(ranks.get(2).getReward()).isEqualTo(1500000l);
        assertThat(ranks.get(3).getRanking()).isEqualTo(2);
        assertThat(ranks.get(3).getReward()).isEqualTo(30000000l);
        assertThat(ranks.get(4).getRanking()).isEqualTo(1);
        assertThat(ranks.get(4).getReward()).isEqualTo(2000000000l);
    }


}
