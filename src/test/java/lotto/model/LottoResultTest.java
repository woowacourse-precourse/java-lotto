package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 당첨_갯수_테스트(){
        LottoResult lottoResult = new LottoResult();
        int count = lottoResult.measureWinningNumber(Arrays.asList(1,2,3,4,5,6), Set.of(1,2,3,4,5,7));
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 보너스_번호_일치여부_테스트(){
        LottoResult lottoResult = new LottoResult();
        int bonusCount = lottoResult.countBonus(Arrays.asList(1,2,3,4,5,6), 7);
        assertThat(bonusCount).isEqualTo(0);
    }
}