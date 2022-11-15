package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {

    @DisplayName("로또 번호 6개 일치")
    @Test
    public void sixNumberMatch() {
        int countOfMatch = 6;
        boolean matchBonus = false;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST_PLACE);
    }

    @DisplayName("로또 번호 5개 일치하고 보너스 볼 일치")
    @Test
    public void fiveNumberAndBonusMatch() {
        int countOfMatch = 5;
        boolean matchBonus = true;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND_PLACE);
    }

    @DisplayName("로또 번호 5개 일치하고 보너스 볼 불일치")
    @Test
    public void fiveNumberAndBonusMissMatch() {
        int countOfMatch = 5;
        boolean matchBonus = false;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @DisplayName("로또 번호 4개 일치")
    @Test
    public void fourNumberMatch() {
        int countOfMatch = 4;
        boolean matchBonus = true;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @DisplayName("로또 번호 3개 일치")
    @Test
    public void threeNumberMatch() {
        int countOfMatch = 3;
        boolean matchBonus = false;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @DisplayName("로또 번호 3개 미만 일치")
    @Test
    public void missMatch() {
        int countOfMatch = 2;
        boolean matchBonus = false;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, matchBonus);

        assertThat(lottoRank).isEqualTo(LottoRank.NOTHING);
    }
}
