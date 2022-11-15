package lotto.domain;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;

public class LottoRankTest {
    
    @DisplayName("매칭 수, 보너스 번호 일치 여부를 입력받아 로또 순위를 올바르게 반환한다.")
    @Test
    void getLottoRankTest() {
        // given
        Tuple result1 = new Tuple(6, false);
        Tuple result2 = new Tuple(5, true);
        Tuple result3 = new Tuple(5, false);
        Tuple result4 = new Tuple(4, false);
        Tuple result5 = new Tuple(3, false);
        
        // when
        LottoRank lottoRank1 = LottoRank.getLottoRank(result1);
        LottoRank lottoRank2 = LottoRank.getLottoRank(result2);
        LottoRank lottoRank3 = LottoRank.getLottoRank(result3);
        LottoRank lottoRank4 = LottoRank.getLottoRank(result4);
        LottoRank lottoRank5 = LottoRank.getLottoRank(result5);
        
        // then 
        Assertions.assertEquals(WIN_1ST, lottoRank1);
        Assertions.assertEquals(WIN_2ND, lottoRank2);
        Assertions.assertEquals(WIN_3RD, lottoRank3);
        Assertions.assertEquals(WIN_4TH, lottoRank4);
        Assertions.assertEquals(WIN_5TH, lottoRank5);
    }
    
}
