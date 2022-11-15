package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("로또와 보너스 번호가 엮겨있는 WinningLotto 객체 생성 후 값 접근 테스트")
    @ParameterizedTest
    @MethodSource("lottoSourceGetter")
    void WINNING_LOTTO_값_접근_테스트(List<Integer> lottoSource, int bonusNumber) {
        Lotto lotto = new Lotto(lottoSource);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        assertAll(
                () -> assertThat(winningLotto.getWinningLotto()).isEqualTo(lotto),
                () -> assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber)
        );

    }

    @DisplayName("보너스 번호가 로또에 이미 존재할 경우 발생하는 예외 테스트")
    @ParameterizedTest
    @MethodSource("errorLottoSourceGetter")
    void WINNING_LOTTO_중복_예외_테스트(List<Integer> lottoSource, int bonusNumber) {
        Lotto lotto = new Lotto(lottoSource);
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 로또 번호에 포함되면 안됩니다.");
    }

    private static Stream<Arguments> lottoSourceGetter() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 31),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 31),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 31),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 31),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), 31),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 31),
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), 31),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), 31)
        );
    }

    private static Stream<Arguments> errorLottoSourceGetter() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 7),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 8),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 9),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), 10),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 11),
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), 12),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), 13)
        );
    }
}
