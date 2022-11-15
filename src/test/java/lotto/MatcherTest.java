package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatcherTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(8, 21, 23, 17, 40, 33);
    private static final int BONUS_NUMBER = 4;

    @DisplayName("3개 일치, 보너스볼 불일치")
    @Test
    void case1() {
        final List<Integer> consumerNumbers = List.of(8, 21, 23, 41, 42, 43);

        Matcher matcher = new Matcher(consumerNumbers, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(matcher.getMatchingWinningNumberCount())
                .isEqualTo(3);
        assertThat(matcher.getMatchingBonusNumberCount())
                .isEqualTo(0);
    }

    @DisplayName("4개 일치, 보너스볼 일치")
    @Test
    void case2() {
        List<Integer> consumerNumbers = List.of(8, 21, 23, 17, 4, 43);

        Matcher matcher = new Matcher(consumerNumbers, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(matcher.getMatchingWinningNumberCount())
                .isEqualTo(4);
        assertThat(matcher.getMatchingBonusNumberCount())
                .isEqualTo(1);
    }

    @DisplayName("5개 일치, 보너스볼 불일치")
    @Test
    void case3() {
        List<Integer> consumerNumbers = List.of(8, 21, 23, 17, 40, 43);

        Matcher matcher = new Matcher(consumerNumbers, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(matcher.getMatchingWinningNumberCount())
                .isEqualTo(5);
        assertThat(matcher.getMatchingBonusNumberCount())
                .isEqualTo(0);
    }

    @DisplayName("5개 일치, 보너스볼 일치")
    @Test
    void case4() {
        List<Integer> consumerNumbers = List.of(8, 21, 23, 17, 40, 4);

        Matcher matcher = new Matcher(consumerNumbers, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(matcher.getMatchingWinningNumberCount())
                .isEqualTo(5);
        assertThat(matcher.getMatchingBonusNumberCount())
                .isEqualTo(1);
    }

    @DisplayName("6개 일치, 보너스볼 불일치")
    @Test
    void case5() {
        List<Integer> consumerNumbers = List.of(8, 21, 23, 17, 40, 33);

        Matcher matcher = new Matcher(consumerNumbers, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(matcher.getMatchingWinningNumberCount())
                .isEqualTo(6);
        assertThat(matcher.getMatchingBonusNumberCount())
                .isEqualTo(0);
    }
}