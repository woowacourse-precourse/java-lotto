package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRewardTest {

    @Test
    void 번호3개_일치_보너스번호_비일치시_5등반환() throws Exception {
        LottoReward result = LottoReward.from(3, false);
        assertThat(result).isEqualTo(LottoReward.FIFTH);
    }

    @Test
    void 번호4개_일치_보너스번호_비일치시_4등반환() throws Exception {
        LottoReward result = LottoReward.from(4, false);
        assertThat(result).isEqualTo(LottoReward.FIRTH);
    }

    @Test
    void 번호5개_일치_보너스번호_비일치시_3등반환() throws Exception {
        LottoReward result = LottoReward.from(5, false);
        assertThat(result).isEqualTo(LottoReward.THIRD);
    }

    @Test
    void 번호5개_일치_보너스번호_일치시_2등반환() throws Exception {
        LottoReward result = LottoReward.from(5, true);
        assertThat(result).isEqualTo(LottoReward.SECOND);
    }

    @Test
    void 번호6개_일치_보너스번호_비일치시_1등반환() throws Exception {
        LottoReward result = LottoReward.from(6, false);
        assertThat(result).isEqualTo(LottoReward.FIRST);
    }

    @Test
    void 일치하는_번호_등수가_없을경우_null반환() throws Exception {
        LottoReward lottoReward = LottoReward.from(0, false);
        assertThat(lottoReward).isNull();
    }
}