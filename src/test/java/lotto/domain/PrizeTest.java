package lotto.domain;

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
        Prize threeMatchAnswer = Prize.THREE_MATCH;
        Prize threeMatch2 = Prize.findPrizeType(new MatchCount(3, 1));
        Prize threeMatch2Answer = Prize.THREE_MATCH;

        Prize fourMatch = Prize.findPrizeType(new MatchCount(4, 0));
        Prize fourMatchAnswer = Prize.FOUR_MATCH;
        Prize fourMatch2 = Prize.findPrizeType(new MatchCount(4, 1));
        Prize fourMatch2Answer = Prize.FOUR_MATCH;

        Prize fiveMatch = Prize.findPrizeType(new MatchCount(5, 0));
        Prize fiveMatchAnswer = Prize.FIVE_MATCH;

        Prize fiveBonusMatch = Prize.findPrizeType(new MatchCount(5, 1));
        Prize fiveBonusMatchAnswer = Prize.FIVE_BONUS_MATCH;

        Prize sixMatch = Prize.findPrizeType(new MatchCount(6, 0));
        Prize sixMatchAnswer = Prize.SIX_MATCH;

        Prize noneMatch = Prize.findPrizeType(new MatchCount(2, 0));
        Prize noneMatchAnswer = Prize.NONE;

        assertThat(threeMatch).isEqualTo(threeMatchAnswer);
        assertThat(threeMatch2).isEqualTo(threeMatch2Answer);
        assertThat(fourMatch).isEqualTo(fourMatchAnswer);
        assertThat(fourMatch2).isEqualTo(fourMatch2Answer);
        assertThat(fiveMatch).isEqualTo(fiveMatchAnswer);
        assertThat(fiveBonusMatch).isEqualTo(fiveBonusMatchAnswer);
        assertThat(sixMatch).isEqualTo(sixMatchAnswer);
        assertThat(noneMatch).isEqualTo(noneMatchAnswer);
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