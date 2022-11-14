package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RankTest {


    @Nested
    @DisplayName("등수 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class FromTest {

        @DisplayName("로또 번호: 3, 21, 25, 28, 4, 9")
        @ParameterizedTest(name = "당첨 번호: {1}, 보너스 번호: {2} 결과: {3}")
        @MethodSource("lottoTestCases")
        void 등수_테스트(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber, Rank expect) {
            //given
            Lotto lotto = new Lotto(numbers);
            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

            //when
            Rank rank = Rank.from(winningLotto, lotto);

            //then
            assertThat(rank).isEqualTo(expect);
        }

        /*
         * 로또 번호, 당첨 번호, 보너스 번호, 결과 등수
         * */
        private Stream<Arguments> lottoTestCases() {
            return Stream.of(
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(1, 2, 3, 4, 5, 6), 7, NOTHING),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(1, 2, 3, 4, 5, 6), 9, NOTHING),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 2, 3, 4, 5, 6), 7, FIFTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 2, 3, 4, 5, 6), 9, FIFTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 4, 5, 6), 7, FOURTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 4, 5, 6), 9, FOURTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 6), 7, THIRD),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 6), 9, SECOND),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 9), 7, FIRST)
            );
        }
    }
}