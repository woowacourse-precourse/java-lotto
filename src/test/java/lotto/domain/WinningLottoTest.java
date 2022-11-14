package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {
    
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void 당첨_로또_테스트(int winningNumberCount, boolean hasBonus, WinningLotto result) {
        WinningLotto winningLotto = WinningLotto.from(winningNumberCount, hasBonus);
        assertThat(winningLotto).isEqualTo(result);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(1, true, WinningLotto.NOTHING),
                Arguments.arguments(2, true, WinningLotto.NOTHING),
                Arguments.arguments(3, false, WinningLotto.FIFTH),
                Arguments.arguments(4, true, WinningLotto.FOURTH),
                Arguments.arguments(5, false, WinningLotto.THIRD),
                Arguments.arguments(5, true, WinningLotto.SECOND),
                Arguments.arguments(6, false, WinningLotto.FIRST)
        );
    }
}
