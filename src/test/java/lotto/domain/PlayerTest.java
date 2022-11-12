package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("1000원으로 나누어 떨어지는 금액의 플레이어를 새로 만든다.")
    void createPlayerWithInitialMoneySuccess() {
        long testMoney = 4000;
        assertThatCode(() -> new Player(testMoney))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않는 금액의 플레이어를 새로 만들면 예외가 발생한다.")
    void createPlayerWithInitialMoneyThrowsException() {
        long testMoney = 4300;
        assertThatThrownBy(() -> new Player(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 숫자 개수를 구한다")
    void compareLottoAndWinningNumber(Lotto lotto, List<Integer> winningNumber, int result) {
        Player player = new Player(1000);
        assertThat(player.compareWinningNumbers(lotto, winningNumber)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), List.of(7,8,9,10,11,12), 0),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), List.of(7,8,9,10,11,12), 1),
                Arguments.of(new Lotto(List.of(1,2,3,4,7,8)), List.of(7,8,9,10,11,12), 2),
                Arguments.of(new Lotto(List.of(1,2,3,7,8,9)), List.of(7,8,9,10,11,12), 3),
                Arguments.of(new Lotto(List.of(1,2,7,8,9,10)), List.of(7,8,9,10,11,12), 4),
                Arguments.of(new Lotto(List.of(1,7,8,9,10,11)), List.of(7,8,9,10,11,12), 5),
                Arguments.of(new Lotto(List.of(7,8,9,10,11,12)), List.of(7,8,9,10,11,12), 6)
        );
    }
}
