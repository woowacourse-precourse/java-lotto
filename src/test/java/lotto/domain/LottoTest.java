package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작거나 45보다 큰 숫자가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumbers() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 3, 0, 46, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBERS_OUT_OF_RANGE);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교하는 기능")
    @Test
    void createLottoContainsBonusNumber() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThat(lotto.contains(bonusNumber)).isTrue();
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하는 기능")
    @Test
    void createLottoContains3WinningNumbers() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(List.of(1, 3, 5, 7, 9, 11));

        assertThat(lotto.countMatchingNumbers(winningLotto)).isEqualTo(3);
    }

    @DisplayName("맞춘 번호의 갯수에 따라 당첨 결과를 반환한다.")
    @ParameterizedTest(name = "로또 번호 : {0}, 결과 : {1}")
    @MethodSource("lottoResultSources")
    void createLottoResultTest(Lotto purchasedLotto, Rank result) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(winningNumbers), 7);

        assertThat(winningLotto.getResult(purchasedLotto)).isEqualTo(result);
    }

    public static Stream<Arguments> lottoResultSources() {
        return Stream.of(
                Arguments.arguments(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.arguments(Lotto.of(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.arguments(Lotto.of(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.arguments(Lotto.of(List.of(1, 2, 3, 4, 7, 8)), Rank.FOURTH),
                Arguments.arguments(Lotto.of(List.of(1, 2, 3, 7, 8, 9)), Rank.FIFTH),
                Arguments.arguments(Lotto.of(List.of(1, 2, 7, 8, 9, 10)), Rank.MISS)
        );
    }

    @DisplayName("로또 번호를 문자열로 출력하는 기능")
    @Test
    void createCommonLotto() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        String expected = "[1, 2, 3, 4, 5, 6]";

        assertThat(lotto.toString()).isEqualTo(expected);
    }
}
