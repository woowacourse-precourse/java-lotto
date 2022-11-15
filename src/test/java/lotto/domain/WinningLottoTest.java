package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    @DisplayName("당첨 번호와 보너스 번호 중에 1~45 까지의 범위 밖의 숫자 있을 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidNumberParameter")
    void containWinningLottoByInvalidNumber(List<Integer> winningNumbers, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInvalidNumberParameter() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 17, 23, 38, 45, 777), 7),
                Arguments.of(Arrays.asList(6, 11, 13, 29, 33, 40), 99)
        );
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void containWinningLottoByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(3, 11, 26, 28, 34, 41), 26))
                .isInstanceOf(IllegalArgumentException.class);
    }
}