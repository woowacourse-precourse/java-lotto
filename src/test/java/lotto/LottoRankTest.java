package lotto;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoRank.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoRankTest {
    @DisplayName("로또 당첨 확인.")
    @Test
    void createWinNumbers() {

        assertThat(LottoRank.valueOf(0,false)).isEqualTo(NOTHING);
        assertThat(LottoRank.valueOf(1,false)).isEqualTo(NOTHING);
        assertThat(LottoRank.valueOf(2,false)).isEqualTo(NOTHING);
        assertThat(LottoRank.valueOf(3,false)).isEqualTo(FIFTH);
        assertThat(LottoRank.valueOf(4,false)).isEqualTo(FOURTH);
        assertThat(LottoRank.valueOf(5,false)).isEqualTo(THIRD);
        assertThat(LottoRank.valueOf(5,true)).isEqualTo(SECOND);
        assertThat(LottoRank.valueOf(6,false)).isEqualTo(FIRST);

    }
}
