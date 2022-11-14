package util;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {

    @DisplayName("1등 당첨 확인")
    @Test
    void firstRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        6,
                        6)
                   ).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 당첨 확인")
    @Test
    void secondRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        5,
                        6)
                   ).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 당첨 확인")
    @Test
    void thirdRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        5,
                        15)
                   ).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 당첨 확인")
    @Test
    void fourthRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        4,
                        14)
                   ).isEqualTo(LottoRank.FOURTH);
    }


    @DisplayName("5등 당첨 확인")
    @Test
    void fifthRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        3,
                        4)
                   ).isEqualTo(LottoRank.FIFTH);
    }


    @DisplayName("미당첨 확인")
    @Test
    void losingTicketRankOfLotto() {
        assertThat(LottoRank.getRank(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        1,
                        2)
                   ).isEqualTo(LottoRank.LOSING_TICKET);
    }

}