package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 간 같은 번호의 개수를 반환한다")
    @ParameterizedTest
    @MethodSource("twoLottosToCompare")
    public void canGetNumberOfSameDigitsOfTwoLottos(
        final List<Integer> lottoANumbers,
        final List<Integer> lottoBNumbers,
        int expectedNumberOfSameDigits
    ) {
        final var sutA = new Lotto(lottoANumbers);
        final var sutB = new Lotto(lottoBNumbers);

        final int numberOfSameDigits = sutA.numberOfSameDigits(sutB);

        assertEquals(expectedNumberOfSameDigits, numberOfSameDigits);
    }

    static Stream<Arguments> twoLottosToCompare() throws Throwable {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), 5),
            Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), Arrays.asList(7, 5, 4, 3, 2, 1), 5)
        );
    }

    @DisplayName("보너스 번호 보유 여부를 반환한다")
    @ParameterizedTest
    @MethodSource("twoLottosToCompareWithBonusNumber")
    public void canGetNumberOfSameDigitsOfTwoLottosIncludingBonusNumber(
        final List<Integer> lottoANumbers,
        int bonusNumber,
        boolean expectedMatch
    ) {
        final var sutA = new Lotto(lottoANumbers);

        final boolean matched = sutA.hasBonusNumber(bonusNumber);

        assertEquals(expectedMatch, matched);
    }

    static Stream<Arguments> twoLottosToCompareWithBonusNumber() throws Throwable {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, true),
            Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), 7, false),
            Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), 1, true)
        );
    }
}
