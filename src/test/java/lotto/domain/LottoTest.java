package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.errorenum.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.NOT_6_LENGTH.printError());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.DUPLICATE_FOUND.printError());
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideListsForRangeOutTest")
    void createLottoByNumberOutOfRange(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.NOT_IN_RANGE.printError());
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

    @DisplayName("로또 번호를 오름차순으로 정렬하여 가져온다")
    @Test
    void checkLottoSortedList() {
        List<Integer> origin = List.of(6, 45, 44, 4, 15, 10);
        List<Integer> sortedResult = List.of(4, 6, 10, 15, 44, 45);

        List<Integer> sortedNumbers = new Lotto(origin).getSortedNumbers();

        assertThat(sortedNumbers).isEqualTo(sortedResult);
    }

    @DisplayName("로또 객체 내부의 번호 자체의 정렬은 변하지 않아야 한다")
    @Test
    void checkLottoNumbersUnchanged() {
        //given
        List<Integer> origin = List.of(45, 40, 44, 1, 29, 16);
        Lotto lotto = new Lotto(origin);

        //when
        List<Integer> sorted = lotto.getSortedNumbers();

        //then
        assertThat(lotto.getNumbers()).isEqualTo(origin);
    }
}
