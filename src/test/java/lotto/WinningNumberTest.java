package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("잘못된 당첨 번호를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6s", "1 2 3 4 5 6", "1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5,, 6, 7"})
    void givenUserInput_whenIllegalWinningNumbers_thenThrowException(String input) {
        assertThatThrownBy(() -> {
            new WinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 보너스 번호를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1s", "13q", "", "52"})
    void givenBonusNumber_whenIllegalInput_thenThrowException(String input) {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        assertThatThrownBy(() -> {
            winningNumber.setBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호를 조회해서 일치 개수 별 등급을 리턴한다.")
    @Test
    void givenLottoNumber_whenJudge_thenReturnGrade() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        winningNumber.setBonusNumber("7");

        assertThat(winningNumber.judge(new Lotto(List.of(3, 2, 1, 4, 5, 6)))).isEqualTo(Grade.FIRST);
        assertThat(winningNumber.judge(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(Grade.SECOND);
        assertThat(winningNumber.judge(new Lotto(List.of(5, 1, 3, 2, 10, 6)))).isEqualTo(Grade.THIRD);
        assertThat(winningNumber.judge(new Lotto(List.of(1, 2, 3, 4, 10, 11)))).isEqualTo(Grade.FORTH);
        assertThat(winningNumber.judge(new Lotto(List.of(1, 2, 3, 10, 11, 12)))).isEqualTo(Grade.FIFTH);
        assertThat(winningNumber.judge(new Lotto(List.of(1, 2, 10, 11, 12, 13)))).isEqualTo(Grade.NOTHING);
        assertThat(winningNumber.judge(new Lotto(List.of(1, 2, 10, 11, 12, 7)))).isEqualTo(Grade.NOTHING);
    }
}