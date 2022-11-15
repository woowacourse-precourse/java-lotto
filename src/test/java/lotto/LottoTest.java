package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionHandler.WRONG_NUMBERS_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionHandler.DUPLICATED_LOTTO_NUMBERS);
    }

    @DisplayName("당첨 번호와 로또 번호 점수 매기기")
    @ParameterizedTest
    @MethodSource("provideWinNumbers")
    void compareWithWinNumbers(List<Integer> winNumbers, int result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.compareWithWinNumbers(winNumbers)).isEqualTo(result);

    }

    private static Stream<Arguments> provideWinNumbers() {
        return Stream.of(
                Arguments.of(List.of(1), 1),
                Arguments.of(List.of(1, 2), 2),
                Arguments.of(List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3, 4), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @DisplayName("당첨 번호와 보너스 번호 점수 매기기")
    @ParameterizedTest
    @MethodSource("provideBonusNumber")
    void compareWithBonusNumber(int winNumbers, int result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.compareWithBonusNumber(winNumbers)).isEqualTo(result);

    }

    private static Stream<Arguments> provideBonusNumber() {
        return Stream.of(
                Arguments.of(3, 1),
                Arguments.of(7, 0)
        );
    };

    @DisplayName("당첨 번호와 보너스 번호 점수로 등수 매기기")
    @ParameterizedTest
    @MethodSource("provideCount")
    void checkGradeTest(int correctCount, int bonusCount, Prize prize) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.checkGrade(correctCount, bonusCount);
        Assertions.assertThat(lotto.getGrade()).isEqualTo(prize);

    }

    private static Stream<Arguments> provideCount() {
        return Stream.of(
                Arguments.of(6, 0, Prize.FIRST),
                Arguments.of(5, 1, Prize.SECOND),
                Arguments.of(5, 0, Prize.THIRD),
                Arguments.of(4, 0, Prize.FOURTH),
                Arguments.of(3, 0, Prize.FIFTH),
                Arguments.of(2, 0, Prize.NONE)
                );
    };

}
