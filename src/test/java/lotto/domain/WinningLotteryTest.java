package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLotteryTest {
    private final WinningLottery winningLottery = new WinningLottery(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

    private static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoResult.SIX_CORRECT),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoResult.FIVE_BONUS_CORRECT),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 9)), LottoResult.FIVE_CORRECT),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoResult.FOUR_CORRECT),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), LottoResult.THREE_CORRECT),
                Arguments.of(new Lotto(List.of(1, 2, 11, 12, 13, 14)), LottoResult.TWO_CORRECT),
                Arguments.of(new Lotto(List.of(1, 12, 13, 14, 15, 16)), LottoResult.ONE_CORRECT)
        );
    }

    @DisplayName("setBonusNumber 메서드는 중복이 없는 숫자만을 받아들인다")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 45})
    void case1(int input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertDoesNotThrow(() -> winningLottery.setBonusNumber(bonusNumber));
    }

    @DisplayName("setBonusNumber 메서드에 중복인 숫자가 오면 IEA 예외")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void case2(int input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertThrows(IllegalArgumentException.class, () -> winningLottery.setBonusNumber(bonusNumber));
    }

    @DisplayName("getResult 메서드는 당첨 결과를 알맞게 LottoResult 형태로 반환한다")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void case3(Lotto lotto, LottoResult result) {
        winningLottery.setBonusNumber(new BonusNumber(7));
        assertThat(winningLottery.getResult(lotto)).isEqualTo(result);
    }
}
