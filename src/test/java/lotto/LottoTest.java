package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.errorenum.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_6_LENGTH.getCode());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.DUPLICATE_FOUND.getCode());
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideListsForRangeOutTest")
    void createLottoByNumberOutOfRange(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_IN_RANGE.getCode());
    }

    private static Stream<List<Integer>> provideListsForRangeOutTest() {
        return Stream.of(
                List.of(1, 4, 7, 15, 30, 46),
                List.of(0, 1, 2, 3, 4, 5)
        );
    }

    @DisplayName("로또 번호에 범위 내의 숫자만 포함되어있다면 테스트를 통과한다")
    @ParameterizedTest
    @MethodSource("provideListsForRangeSuccessTest")
    void createLottoByNumberInRange(List<Integer> numbers) {
        new Lotto(numbers);

        //then : test pass
    }

    private static Stream<List<Integer>> provideListsForRangeSuccessTest() {
        return Stream.of(
                List.of(1, 4, 7, 15, 30, 40),
                List.of(45, 1, 2, 3, 4, 5),
                List.of(1, 10, 20, 30, 40, 45)
        );
    }
}
