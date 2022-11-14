package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {
    @DisplayName("당첨 번호와 보너스 번호를 정상적으로 입력받았을 경우 CheckLotto 객체를 반환한다.")
    @Test
    void winningLottery() {
        String bonusNumber = "31";

        assertThat(Winning.getWinningLottery(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(CheckLotto.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 오류가 발생한다.")
    @Test
    void duplicateNumber() {
        String bonusNumber = "3";

        assertThatThrownBy(() -> Winning.getWinningLottery(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값을 숫자로 변환할 수 없으면 오류가 발생한다.")
    @Test
    void validNumberForm() {
        String bonusNumber = "100$";

        assertThatThrownBy(() -> Winning.getWinningLottery(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 간 중복이 있으면 오류가 발생한다.")
    @Test
    void bonusNumberDuplication() {
        String bonusNumber = "1";

        assertThatThrownBy(() -> Winning.getWinningLottery(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위가 1~45에 속하지 않으면 오류가 발생한다.")
    @Test
    void invalidLottoRange() {
        assertThatThrownBy(() -> Winning.convertToNumbers(List.of("1", "2", "3", "4", "5", "60")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 갯수가 6개가 아닌 경우 오류가 발생한다.")
    @Test
    void validNumberOfWinningNumber() {
        assertThatThrownBy(() -> Winning.convertToNumbers(List.of("1", "2", "3", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호 간 중복이 있으면 오류가 발생한다.")
    @Test
    void winningNumbersDuplication() {
        assertThatThrownBy(() -> Winning.convertToNumbers(List.of("1", "2", "3", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}