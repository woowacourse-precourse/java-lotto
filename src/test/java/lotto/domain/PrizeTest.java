package lotto;

import lotto.domain.MatchCount;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

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


    @DisplayName("상금 계산 테스트")
    @Test
    void getPrizeMoneyTest() {
        int count = 2;
        int threeMatch = Prize.getPrizeMoney(Prize.THREE_MATCH, count);
        int answer = 5000*count;

        int fiveBonusMatch = Prize.getPrizeMoney(Prize.FIVE_BONUS_MATCH, count);
        int answer2 = 30000000*count;

        assertThat(threeMatch).isEqualTo(answer);
        assertThat(fiveBonusMatch).isEqualTo(answer2);
    }

    @DisplayName("당첨 결과 리스트 생성 테스트")
    @Test
    void makeResultMessageTest() {
        HashMap<Prize, Integer> totalMatchResult = new HashMap<>();
        totalMatchResult.put(Prize.FOUR_MATCH, 2);
        totalMatchResult.put(Prize.FIVE_MATCH, 1);

        List<String> messages = Prize.makeResultMessage(totalMatchResult);

        List<String> answer = List.of(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 2개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개");
        assertThat(messages).isEqualTo(answer);
    }
}