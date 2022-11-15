package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    @DisplayName("숫자 6개와 보너스 번호 1개 중 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBonusNumber.of(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideForLottoResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 9, 10)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), Rank.MISS),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), Rank.MISS),
                Arguments.of(new Lotto(List.of(1, 9, 10, 11, 12, 13)), Rank.MISS),
                Arguments.of(new Lotto(List.of(9, 10, 11, 12, 13, 14)), Rank.MISS)
        );
    }

    @ParameterizedTest(name = "로또 번호와 당첨 번호를 비교하여 당첨 내역을 구한다")
    @MethodSource("provideForLottoResult")
    void lottoResult(Lotto lotto, Rank rank) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBonusNumber.of(7));

        assertThat(winningLotto.rank(lotto)).isEqualTo(rank);
    }
}
