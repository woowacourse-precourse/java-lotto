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

class LottoTest {

    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 당첨 금액은 {1}입니다.")
    @MethodSource("lottoAndMoney")
    void 로또_당첨금_구하는_기능(Lotto lotto, int expectedWinningAmount) {
        assertThat(lotto.calculateWinningAmount(winningNumbers)).isEqualTo(expectedWinningAmount);
    }

    static Stream<Arguments> lottoAndMoney() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 2_000_000_000)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 30_000_000)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 1_500_000)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), 50_000)
                , Arguments.of(new Lotto(List.of(10, 2, 3, 4, 7, 9)), 5_000)
                , Arguments.of(new Lotto(List.of(11, 2, 3, 10, 8, 9)), 0)
        );
    }

    @ParameterizedTest(name = "로또 비교 결과 {1}등 당첨!")
    @MethodSource("lottoAndPrize")
    void 로또_비교_결과가_몇_등_당첨인지_확인하는_기능(Lotto lotto, LottoPrize expected) {
        assertThat(lotto.getPrize(winningNumbers)).isEqualTo(expected);
    }

    static Stream<Arguments> lottoAndPrize() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoPrize.FIRST)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoPrize.SECOND)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), LottoPrize.THIRD)
                , Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoPrize.FOURTH)
                , Arguments.of(new Lotto(List.of(10, 2, 3, 4, 7, 9)), LottoPrize.FIFTH)
                , Arguments.of(new Lotto(List.of(11, 2, 3, 10, 8, 9)), LottoPrize.LOSE)
        );
    }
}
