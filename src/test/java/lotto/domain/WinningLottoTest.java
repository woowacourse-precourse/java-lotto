package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    private static Stream<Arguments> invalidLottoNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 3, 3, 4, 5, 6)));
    }

    @DisplayName("보너스 볼 번호는 당첨 번호와 중복되면 안된다.")
    @Test
    void duplicate_bonus_number() {
        List<Integer> winningLottos = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusBallNumber = 6;

        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.of(winningLottos, bonusBallNumber));
    }

    @DisplayName("당첨 번호는 중복되지 않은 6자리 숫자이다.")
    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    void invalid_lotto_numbers(List<Integer> winningNumbers) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.of(winningNumbers, 45));
    }
}
