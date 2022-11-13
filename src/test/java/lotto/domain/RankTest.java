package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("1등 당첨 코멘트를 확인한다.")
    @Test
    void createRankFirstComment() {
        assertThat(Rank.first.getComment())
                .isEqualTo("6개 일치 (2,000,000,000원)");
    }

    @DisplayName("2등 당첨 코멘트를 확인한다.")
    @Test
    void createRankSecondComment() {
        assertThat(Rank.second.getComment())
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
    }

    @DisplayName("3등 당첨 코멘트를 확인한다.")
    @Test
    void createRankThirdComment() {
        assertThat(Rank.third.getComment())
                .isEqualTo("5개 일치 (1,500,000원)");
    }

    @DisplayName("1등 당첨 금액을 확인한다.")
    @Test
    void createRankFirstPrice() {
        assertThat(Rank.first.getPrice())
                .isEqualTo(2000000000);
    }

    @DisplayName("2등 당첨 금액을 확인한다.")
    @Test
    void createRankSecondPrice() {
        assertThat(Rank.second.getPrice())
                .isEqualTo(30000000);
    }

    @DisplayName("3등 당첨 금액을 확인한다.")
    @Test
    void createRankThirdPrice() {
        assertThat(Rank.third.getPrice())
                .isEqualTo(1500000);
    }

    @DisplayName("당첨 순위를 부여한다. (1등)")
    @Test
    void setRankFirst() {
        Rank result = Rank.etc;
        assertThat(result.setRank(6, false).getPrice())
                .isEqualTo(2000000000);
    }

    @DisplayName("당첨 순위를 부여한다. (2등)")
    @Test
    void setRankSecond() {
        Rank result = Rank.etc;
        assertThat(result.setRank(5, true).getPrice())
                .isEqualTo(30000000);
    }

    @DisplayName("당첨 순위를 부여한다. (3등)")
    @Test
    void setRankThird() {
        Rank result = Rank.etc;
        assertThat(result.setRank(5, false).getPrice())
                .isEqualTo(1500000);
    }


}