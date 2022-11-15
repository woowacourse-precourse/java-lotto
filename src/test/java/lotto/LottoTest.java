package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    private Lotto lottery;

    @BeforeEach
    void setLotteryNumbers() {
        lottery = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }


    @ParameterizedTest
    @ValueSource(ints = {6, 12, 5, 2, 7})
    @DisplayName("주어진 수만큼 로또를 생성하는지 테스트")
    void generateLotteriesTest(int generateCount) {
        assertThat(Lotto.generateLotteries(generateCount).size()).isEqualTo(generateCount);
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

    @DisplayName("로또 번호를 오름차순 문자열로 변환한다.")
    @Test
    void toStringTest() {
        assertThat(lottery.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    static Stream<Arguments> generateCompareWinningNumbersTestArg() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 10, LottoResult.Match3),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 4, LottoResult.Match3),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 10, LottoResult.Match4),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 5, LottoResult.Match4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 9), 10, LottoResult.Match5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 9), 6, LottoResult.Match5AndBonus),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 10, LottoResult.Match6),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 10, LottoResult.None)

        );
    }

    @ParameterizedTest
    @MethodSource("generateCompareWinningNumbersTestArg")
    @DisplayName("로또 당첨 결과를 비교하고 LottoResult를 반환한다.")
    void compareWinningNumbersTest(List<Integer> winningNumber, int bonus, LottoResult expected) {
        assertThat(lottery.compareWinningNumbers(winningNumber, bonus)).isEqualTo(expected);
    }

}
