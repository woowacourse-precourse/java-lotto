package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinsTest {

    @DisplayName("당첨된 번호의 개수와 보너스 번호가 주어지면 당첨 결과를 얻는다.")
    @Test
    void 당첨된_번호_개수와_보너스_번호가_주어지면_결과를_얻는다() {
        // given

        // when
        Wins threeMatched = Wins.getWins(3, false);
        Wins fourMatched = Wins.getWins(4, false);
        Wins fiveWithBonusMatched = Wins.getWins(5, true);
        Wins sixMatched = Wins.getWins(6, false);

        // then
        assertAll(
                () -> assertThat(threeMatched).isEqualTo(Wins.THREE_MATCHED),
                () -> assertThat(fourMatched).isEqualTo(Wins.FOUR_MATCHED),
                () -> assertThat(fiveWithBonusMatched).isEqualTo(Wins.FIVE_WITH_BONUS_MATCHED),
                () -> assertThat(sixMatched).isEqualTo(Wins.SIX_MATCHED)
        );
    }
}