package lotto.domain.match;

import static lotto.domain.match.Reward.FIFTH;
import static lotto.domain.match.Reward.FIRST;
import static lotto.domain.match.Reward.FOURTH;
import static lotto.domain.match.Reward.SECOND;
import static lotto.domain.match.Reward.THIRD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Nested
    class createWinningNumbersByOutRangeStdNumber {

        @Test
        void includeStdNumbersMinOut() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        void includeStdNumbersMaxOut() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(46, 2, 3, 4, 5, 6), 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @DisplayName("보너스 번호에 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Nested
    class createWinningNumbersByOutRangeBonusNumber {

        @Test
        void includeBonusNumbersMinOut() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        void includeBonusNumbersMaxOut() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Nested
    class createWinningNumbersByDuplicatedNumber {

        @DisplayName("당첨 번호 사이의 중복")
        @Test
        void duplicateInStdNumbers() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 1, 3, 4, 5, 6), 2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨번호는 중복되면 안됩니다.");
        }

        @Test
        void duplicateInBonusNumbers() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨 번호와 보너스 번호는 중복되면 안됩니다.");
        }
    }

    @ParameterizedTest(name = "일치 개수 {0}: [1, 2, 3, 4, 5, 6]와 당첨 번호 {1}, 보너스 번호 {2}의 비교시 {3}이 결과로 나와야 함")
    @MethodSource("provideMatchAll")
    void matchWithNoBonus(int ignoredMatch, List<Integer> winningStdNumbers,
            int bonusNumber, Reward reward) {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(winningStdNumbers, bonusNumber);

        MatchResults results = winningNumbers.matchAll(lottos);
        MatchResults expect = new MatchResults(Lists.list(reward));

        Assertions.assertThat(results).isEqualTo(expect);
    }

    static Stream<Arguments> provideMatchAll() {
        return Stream.of(
                // 0개 매칭
                Arguments.of(0, List.of(7, 8, 9, 10, 11, 12), 13, null),
                Arguments.of(0, List.of(7, 8, 9, 10, 11, 12), 1, null),
                // 1개 매칭
                Arguments.of(1, List.of(1, 7, 8, 9, 10, 11), 12, null),
                Arguments.of(1, List.of(1, 7, 8, 9, 10, 11), 2, null),
                // 2개 매칭
                Arguments.of(2, List.of(1, 2, 8, 9, 10, 11), 12, null),
                Arguments.of(2, List.of(1, 2, 8, 9, 10, 11), 3, null),
                // 3개 매칭
                Arguments.of(3, List.of(1, 2, 3, 9, 10, 11), 12, FIFTH),
                Arguments.of(3, List.of(1, 2, 3, 9, 10, 11), 4, FIFTH),
                // 4개 매칭
                Arguments.of(4, List.of(1, 2, 3, 4, 10, 11), 12, FOURTH),
                Arguments.of(4, List.of(1, 2, 3, 4, 10, 11), 5, FOURTH),
                // 5개 매칭
                Arguments.of(5, List.of(1, 2, 3, 4, 5, 11), 12, THIRD),
                Arguments.of(5, List.of(1, 2, 3, 4, 5, 11), 6, SECOND),
                // 6개 매칭
                Arguments.of(6, List.of(1, 2, 3, 4, 5, 6), 12, FIRST)
        );
    }
}