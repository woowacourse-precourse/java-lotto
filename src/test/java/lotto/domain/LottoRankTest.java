package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void 당첨번호를_여섯_개_모두_맞춘_경우_1등_당첨() {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(6, false);

        //then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨번호를_다섯_개_맞추고_보너스_점수가_맞은_경우_2등_당첨() {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(5, true);

        //then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 당첨번호를_다섯_개만_맞춘_경우_3등_당첨() {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(5, false);

        //then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 당첨번호를_네_개만_맞춘_경우_4등_당첨() {
        //when
        LottoRank 당첨번호_네_개만_맞춘_결과 = LottoRank.getLottoRank(4, false);
        LottoRank 당첨번호_네_개_맞추고_보너스도_맞춘_결과 = LottoRank.getLottoRank(4, true);

        //then
        Assertions.assertThat(당첨번호_네_개만_맞춘_결과).isEqualTo(LottoRank.FOURTH);
        Assertions.assertThat(당첨번호_네_개_맞추고_보너스도_맞춘_결과).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 당첨번호를_세_개만_맞춘_경우_5등_당첨() {
        //when
        LottoRank 당첨번호_세_개만_맞춘_결과 = LottoRank.getLottoRank(3, false);
        LottoRank 당첨번호_세_개_맞추고_보너스도_맞춘_결과 = LottoRank.getLottoRank(3, true);

        //then
        Assertions.assertThat(당첨번호_세_개만_맞춘_결과).isEqualTo(LottoRank.FIFTH);
        Assertions.assertThat(당첨번호_세_개_맞추고_보너스도_맞춘_결과).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 그_외의_경우는_모두_꽝() {
        //when
        LottoRank 당첨번호_두_개만_맞춘_결과 = LottoRank.getLottoRank(2, false);
        LottoRank 당첨번호_한_개만_맞춘_결과 = LottoRank.getLottoRank(2, false);
        LottoRank 당첨번호_하나도_맞추지_못한_결과 = LottoRank.getLottoRank(2, false);

        //then
        Assertions.assertThat(당첨번호_두_개만_맞춘_결과).isEqualTo(LottoRank.NONE);
        Assertions.assertThat(당첨번호_한_개만_맞춘_결과).isEqualTo(LottoRank.NONE);
        Assertions.assertThat(당첨번호_하나도_맞추지_못한_결과).isEqualTo(LottoRank.NONE);
    }
}