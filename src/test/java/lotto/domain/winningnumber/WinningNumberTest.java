package lotto.domain.winningnumber;

import lotto.domain.lotto.Lotto;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningNumberTest {

    static Stream<Arguments> namedArguments() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 7;
        final WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);
        return Stream.of(
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[6, 5, 4, 3, 2, 1]",
                                new Lotto(List.of(6, 5, 4, 3, 2, 1))),
                        Named.of("1등", Rank.FIRST)
                ),
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[7, 5, 4, 3, 2, 1]",
                                 new Lotto(List.of(7, 5, 4, 3, 2, 1))),
                        Named.of("2등", Rank.SECOND)
                ),
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[20, 5, 4, 3, 2, 1]",
                                new Lotto(List.of(20, 5, 4, 3, 2, 1))),
                        Named.of("3등", Rank.THIRD)
                ),
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[7, 20, 4, 3, 2, 1]",
                                new Lotto(List.of(7, 20, 4, 3, 2, 1))),
                        Named.of("4등", Rank.FOURTH)
                ),
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[7, 20, 21, 3, 2, 1]",
                                new Lotto(List.of(7, 20, 21, 3, 2, 1))),
                        Named.of("5등", Rank.FIFTH)
                ),
                Arguments.of(
                        Named.of("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7",
                                winningNumber),
                        Named.of("[20, 21, 22, 23, 24, 1]",
                                new Lotto(List.of(20, 21, 22, 23, 24, 1))),
                        Named.of("6등", Rank.UNWINNABLE)
                )
        );
    }
    @ParameterizedTest(name = "{0}일 때 {1}이면 {2}이다.")
    @MethodSource("namedArguments")
    void judgeRankByCompareLottoAndWinningNumber(
            final WinningNumber winningNumber,
            final Lotto lotto,
            final Rank rank
    ) {
        // when, then
        assertThat(winningNumber.judge(lotto))
                .isEqualTo(rank);
    }
}