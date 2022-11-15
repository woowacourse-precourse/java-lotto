package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    private static Stream<Arguments> provideWinningNumbersAndExpected() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 26, 3, 45, 15, 6), 3),
                Arguments.of(List.of(13, 21, 32, 24, 15, 6), 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), 5)
        );
    }

    private static Stream<Arguments> provideInvalidNumbers() {

        return Stream.of(
                //범위 오류
                Arguments.of(List.of(1, 2, 3, 4, 5, 68)),
                Arguments.of(List.of(1, 26, 3, 48, 15, 6)),
                Arguments.of(List.of(13, 21, 92, 24, 15, 6)),
                //중복 오류
                Arguments.of(List.of(1, 2, 3, 5, 5, 11)),
                Arguments.of(List.of(1, 1, 3, 5, 6, 11)),
                //크기 오류
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    @DisplayName("제공된 로또번호와 일치하는 번호 개수 세기 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndExpected")
    void calculateMatchCountTest(List<Integer> winningNumbers, int expected) {
        assertThat(lotto.calculateMatchCount(winningNumbers))
                .isEqualTo(expected);
    }

    @DisplayName("보너스 번호를 가지고 있는지 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "7,false", "11,false"})
    void hasBonusNumberTest(int bonusNumber, boolean expected) {
        assertThat(lotto.hasBonusNumber(bonusNumber)).isEqualTo(expected);
    }

    //로또의 생성자 테스트(=유효성 검사)
    @DisplayName("유효하지 않은 리스트로 로또를 생성하려고하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void lottoConstructorTest(List<Integer> invalidNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
