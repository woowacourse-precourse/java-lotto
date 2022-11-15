package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningResultTest {
    WinningResult winningResult;

    @BeforeEach
    void setUpFixture() {
        List<LottoNumber> winningNumbers = from(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        winningResult = new WinningResult(new Lotto(winningNumbers), bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복일경우 예외가 발생한다.")
    @Test
    void duplicateWinningNumberAndBonusNumberTest() {
        assertThatThrownBy(() -> new WinningResult(new Lotto(from(List.of(1,2,3,4,5,6))), new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 비교 테스트, 당첨 번호: [1,2,3,4,5,6] 보너스: 7")
    @MethodSource("purchaseLottoData")
    @ParameterizedTest(name = "당첨: {0}, 번호: {1}")
    void compareLottoTest(Rank rank, List<Integer> numbers) {
        winningResult.compareLotto(new Lotto(from(numbers)));

        assertThat(winningResult.getResults().get(rank)).isEqualTo(1);
    }

    @DisplayName("1등과 5등이 당첨될 경우 총 금액은 2,000,005,000원이다.")
    @Test
    void winningAmountTest() {
        winningResult.compareLotto(new Lotto(from(List.of(1,2,3,4,5,6))));
        winningResult.compareLotto(new Lotto(from(List.of(1,2,3,8,9,10))));

        double winningAmount = winningResult.calculateTotalWinningAmount();

        assertThat(winningAmount).isEqualTo(2_000_005_000);
    }

    static Stream<Arguments> purchaseLottoData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, List.of(1,2,3,4,5,6)),
                Arguments.of(Rank.SECOND, List.of(1,2,3,4,5,7)),
                Arguments.of(Rank.THIRD, List.of(1,2,3,4,5,8)),
                Arguments.of(Rank.FOURTH, List.of(1,2,3,4,8,9)),
                Arguments.of(Rank.FIFTH, List.of(1,2,3,8,9,10))
        );
    }

    private List<LottoNumber> from(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}