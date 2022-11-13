package lotto.domain.winningresult;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTypeTest {
    @Test
    public void 당첨_결과_생성_테스트() {
        int matchedCount = 4;
        boolean isBonusMatched = false;

        WinningType winningType = WinningType.of(matchedCount, isBonusMatched);

        Assertions.assertThat(winningType).isEqualTo(WinningType.FOURTH_PLACE);
    }

    @DisplayName("당첨 번호 5개만 일치하면 3등")
    @Test
    public void 당첨_결과_생성_테스트_3등() {
        //given
        int matchedCount = 5;
        boolean isBonusMatched = false;

        WinningType winningType = WinningType.of(matchedCount, isBonusMatched);

        Assertions.assertThat(winningType).isEqualTo(WinningType.THIRD_PLACE);
    }

    @DisplayName("당첨 번호 5개와 보너스 번호가 일치하면 2등")
    @Test
    public void 당첨_결과_생성_테스트_2등() {
        int matchedCount = 5;
        boolean isBonusMatched = true;

        WinningType winningType = WinningType.of(matchedCount, isBonusMatched);

        Assertions.assertThat(winningType).isEqualTo(WinningType.SECOND_PLACE);
    }

    @DisplayName("일치하는 당첨 번호가 없으면 반환하지 않음")
    @Test
    public void 당첨_결과_생성_테스트_해당_없는_경우() {
        int matchedCount = 1;
        boolean isBonusMatched = false;

        Assertions.assertThatThrownBy(() ->
                WinningType.of(matchedCount, isBonusMatched))
                .isInstanceOf(Exception.class);
    }


}