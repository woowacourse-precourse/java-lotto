package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @DisplayName("로또 번호 비교에 따른 Prize 타입 테스트")
    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("findPrizeTypeTest")
    void 테스트(int winningCount, int bonusCount, Prize expected, String message) {
        Prize result = Prize.findPrizeType(new MatchCount(winningCount, bonusCount));
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> findPrizeTypeTest() {
        return Stream.of(
                Arguments.of(3, 0, Prize.THREE_MATCH, "3개일치"),
                Arguments.of(3, 1, Prize.THREE_MATCH, "3개일치"),
                Arguments.of(4, 0, Prize.FOUR_MATCH, "4개일치"),
                Arguments.of(4, 1, Prize.FOUR_MATCH, "4개일치"),
                Arguments.of(5, 0, Prize.FIVE_MATCH, "5개일치"),
                Arguments.of(5, 1, Prize.FIVE_BONUS_MATCH, "5개+보너스일치"),
                Arguments.of(6, 0, Prize.SIX_MATCH, "6개일치"),
                Arguments.of(2, 0, Prize.NONE, "없음"),
                Arguments.of(0, 0, Prize.NONE, "없음")
        );
    }

    @DisplayName("상금 계산 테스트")
    @Test
    void getPrizeMoneyTest() {
        int count = 2;
        int threeMatch = Prize.calculatePrizeMoney(Prize.THREE_MATCH, count);
        int answer = 5000 * count;

        int fiveBonusMatch = Prize.calculatePrizeMoney(Prize.FIVE_BONUS_MATCH, count);
        int answer2 = 30000000 * count;

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