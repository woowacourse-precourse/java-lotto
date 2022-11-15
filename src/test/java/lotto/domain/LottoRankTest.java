package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    void 예외_테스트() {
        assertThat(LottoRank.decideRank(2,false))
                .isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.decideRank(3,false))
                .isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.decideRank(4,false))
                .isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.decideRank(5,false))
                .isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.decideRank(5,true))
                .isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.decideRank(6,false))
                .isEqualTo(LottoRank.FIRST);

    }
}