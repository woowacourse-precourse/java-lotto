package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Result에 있는 메서드를 테스트한다.")
class ResultTest {
    @DisplayName("compare에 Lotto를 넘겨주면 로또의 결과를 Prize 클래스 형태로 반환된다.")
    @ParameterizedTest
    @MethodSource("compareInitData")
    void returnPrizeWhenCompareLottoAndResult(Lotto lotto, Result result, Prize prize) {
        assertThat(result.compare(lotto)).isEqualTo(prize);
    }

    private static Stream<Arguments> compareInitData() {
        return Stream.of(
                Arguments.of(createLotto(), Result.of(List.of(1, 2, 3, 4, 5, 6), 7), Prize.FIRST),
                Arguments.of(createLotto(), Result.of(List.of(1, 2, 3, 4, 5, 8), 6), Prize.SECOND),
                Arguments.of(createLotto(), Result.of(List.of(1, 2, 3, 4, 5, 8), 10), Prize.THIRD),
                Arguments.of(createLotto(), Result.of(List.of(1, 2, 3, 10, 5, 8), 4), Prize.FOURTH),
                Arguments.of(createLotto(), Result.of(List.of(1, 2, 3, 10, 5, 8), 7), Prize.FOURTH),
                Arguments.of(createLotto(), Result.of(List.of(1, 10, 9, 11, 5, 6), 2), Prize.FIFTH),
                Arguments.of(createLotto(), Result.of(List.of(1, 10, 9, 11, 5, 6), 7), Prize.FIFTH),
                Arguments.of(createLotto(), Result.of(List.of(8, 9, 10, 11, 5, 6), 1), Prize.NONE),
                Arguments.of(createLotto(), Result.of(List.of(8, 9, 10, 11, 5, 6), 7), Prize.NONE)
        );
    }

    private static Lotto createLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("Result가 중복된 숫자를 가지면 오류가 발생한다.")
    @Test
    void createWhenHaveDuplicateNumber() {
        assertThatThrownBy(() -> Result.of(List.of(1, 2, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Result의 보너스 숫자가 당첨 번호와 겹치면 오류가 발생한다.")
    @Test
    void createWhenDuplicateBonusNumber() {
        assertThatThrownBy(() -> Result.of(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Result의 당첨 번호의 숫자가 6과 다르면 오류가 발생한다.")
    @Test
    void createWhenWinningNumbersHasDifferentSize() {
        assertAll(
                () -> assertThatThrownBy(() -> Result.of(List.of(1, 2, 3, 4, 5, 6, 7), 3))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Result.of(List.of(1, 2, 3, 4, 5), 3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}