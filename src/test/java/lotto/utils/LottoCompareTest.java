package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCompareTest {
    @Test
    @DisplayName("로또 한 세트가 1등에 당첨된 경우")
    void compareOneTicket_Correct6_Rank1() {
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 11, 17, 23, 35));
        LottoAnswer lottoAnswer = new LottoAnswer("1,3,11,17,23,35", "45");
        assertThat(LottoCompare.compareOneTicket(lotto, lottoAnswer)).isEqualTo(LottoRank.RANK_1);
    }

    @Test
    @DisplayName("로또 한 세트가 2등에 당첨된 경우")
    void compareOneTicket_Correct5AndBonus_Rank2() {
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 11, 17, 23, 45));
        LottoAnswer lottoAnswer = new LottoAnswer("1,3,11,17,23,35", "45");
        assertThat(LottoCompare.compareOneTicket(lotto, lottoAnswer)).isEqualTo(LottoRank.RANK_2);
    }

    @Test
    @DisplayName("로또 한 세트가 3등에 당첨된 경우")
    void compareOneTicket_Correct5_Rank3() {
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 11, 17, 23, 36));
        LottoAnswer lottoAnswer = new LottoAnswer("1,3,11,17,23,35", "45");
        assertThat(LottoCompare.compareOneTicket(lotto, lottoAnswer)).isEqualTo(LottoRank.RANK_3);
    }

    @Test
    @DisplayName("로또 한 세트가 4등에 당첨된 경우")
    void compareOneTicket_Correct4_Rank4() {
        Lotto lotto = new Lotto(Arrays.asList(2, 3, 11, 17, 23, 36));
        LottoAnswer lottoAnswer = new LottoAnswer("1,3,11,17,23,35", "45");
        assertThat(LottoCompare.compareOneTicket(lotto, lottoAnswer)).isEqualTo(LottoRank.RANK_4);
    }

    @Test
    @DisplayName("로또 한 세트가 5등에 당첨된 경우")
    void compareOneTicket_Correct3_Rank5() {
        Lotto lotto = new Lotto(Arrays.asList(2, 3, 11, 18, 23, 36));
        LottoAnswer lottoAnswer = new LottoAnswer("1,3,11,17,23,35", "45");
        assertThat(LottoCompare.compareOneTicket(lotto, lottoAnswer)).isEqualTo(LottoRank.RANK_5);
    }
}