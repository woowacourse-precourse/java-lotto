package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @DisplayName("로또 번호 비교에 따른 Prize 타입 테스트")
    @Test
    void findPrizeTypeTest() {
        Prize threeMatch = Prize.findPrizeType(new MatchCount(3, 0));
        Prize answer = Prize.THREE_MATCH;

        Prize fiveBonusMatch = Prize.findPrizeType(new MatchCount(5, 1));
        Prize answer2 = Prize.FIVE_BONUS_MATCH;

        assertThat(threeMatch).isEqualTo(answer);
        assertThat(fiveBonusMatch).isEqualTo(answer2);
    }
}