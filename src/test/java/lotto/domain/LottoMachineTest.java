package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {
    private Lotto lotto;

    @BeforeEach
    void setLotto() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void 당첨_로또_테스트(List<Integer> winningNumber, int bonusNumber, WinningLotto result) {
        LottoMachine lottoMachine = new LottoMachine(winningNumber, bonusNumber);

        WinningLotto winningLotto = lottoMachine.isWinningLotto(lotto);
        assertThat(winningLotto).isEqualTo(result);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(List.of(1,2,3,4,5,6), 1, WinningLotto.FIRST),
                Arguments.arguments(List.of(1,2,3,4,5,40), 1, WinningLotto.SECOND),
                Arguments.arguments(List.of(1,2,3,4,5,41), 41, WinningLotto.THIRD),
                Arguments.arguments(List.of(1,2,3,4,40,41), 1, WinningLotto.FOURTH),
                Arguments.arguments(List.of(1,2,3,39,40,41), 1, WinningLotto.FIFTH),
                Arguments.arguments(List.of(10,11,12,13,14,15), 1, WinningLotto.NOTHING)
        );
    }
}
