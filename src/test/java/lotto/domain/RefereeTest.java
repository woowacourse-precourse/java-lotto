package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;

class RefereeTest {
    private Referee referee;
    
    @BeforeEach
    void setUp() {
        referee = new Referee();
    }
    
    @DisplayName("로또 등수를 계산한다.")
    @Test
    void getLottoRank_테스트1() {
        Rank result = referee.getLottoRank(6, true);
        assertThat(result).isEqualTo(Rank.FIRST);
        result = referee.getLottoRank(5, true);
        assertThat(result).isEqualTo(Rank.SECOND);
        result = referee.getLottoRank(5, false);
        assertThat(result).isEqualTo(Rank.THIRD);
        result = referee.getLottoRank(4, true);
        assertThat(result).isEqualTo(Rank.FOURTH);
        result = referee.getLottoRank(3, true);
        assertThat(result).isEqualTo(Rank.FIFTH);
    }   

}
