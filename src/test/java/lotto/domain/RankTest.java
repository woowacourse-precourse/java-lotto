package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RankEnum 테스트")
class RankTest {

    @DisplayName("맞춘 개수의 당첨금 가져오기")
    @Test
    void getMoney() {

        Rank threeRank = Rank.FIVE;

        int money = threeRank.getMoney();

        assertThat(money).isEqualTo(1500000);
    }

    @DisplayName("맞춘 개수의 메시지 출력")
    @Test
    void printMessage() {

        Rank fiveBonus = Rank.FIVEBONUS;
        Rank six = Rank.SIX;

        String fiveBonusMessage = fiveBonus.getMessage();
        String sixMessage = six.getMessage();

        assertThat(fiveBonusMessage).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        assertThat(sixMessage).isEqualTo("6개 일치 (2,000,000,000원) - ");
    }
}