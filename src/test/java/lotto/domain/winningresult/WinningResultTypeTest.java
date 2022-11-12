package lotto.domain.winningresult;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTypeTest {

    @Test
    public void 일치하는_숫자에_따른_당첨_결과_생성_테스트() {
        //given
        int matchedCount = 4;
        boolean isBonusMatched = false;

        WinningResultType winningResultType = WinningResultType.getWinningResult(matchedCount, isBonusMatched);

        Assertions.assertThat(winningResultType).isEqualTo(WinningResultType.FOURTH_PLACE);
    }

    @DisplayName("당첨_번호_5개와_보너스_번호가_일치하면_5등")
    @Test
    public void 일치하는_숫자에_따른_당첨_결과_생성_테스트_2() {
        //given
        int matchedCount = 5;
        boolean isBonusMatched = true;

        WinningResultType winningResultType = WinningResultType.getWinningResult(matchedCount, isBonusMatched);

        Assertions.assertThat(winningResultType).isEqualTo(WinningResultType.FIFTH_PLACE);
    }


}