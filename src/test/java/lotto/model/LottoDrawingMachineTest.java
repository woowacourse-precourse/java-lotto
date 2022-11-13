package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

class LottoDrawingMachineTest {

    private final LottoDrawingMachine drawingMachine = new LottoDrawingMachine();

    @DisplayName("1~45 범위의 서로 중복되지 않는 숫자 6개의 당첨 번호와 1개의 보너스 번호가 전달되면 정상적으로 로또 번호가 뽑힌다.")
    @Test
    void drawLottoAndBonusNumber() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        //when
        drawingMachine.draw(winningNumbers, bonusNumber);

        //then
        assertThat(drawingMachine.getWinningLotto()).isEqualTo(new Lotto(winningNumbers));
        assertThat(drawingMachine.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void drawLottoByOverSize() {
        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);

        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("각 당첨 번호가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void drawLottoByOverRange() {
        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5, 50), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("각 당첨 번호가 서로 중복되면 예외가 발생한다.")
    @Test
    void drawLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_DUPLICATION);
    }

    @DisplayName("보너스 번호가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void drawBonusNumberByOverRange() {
        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void drawBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_BONUS_NUMBER_DUPLICATION);
    }
}
