package lotto.domain;

import handler.console.ConsoleInput;
import handler.console.ConsoleOutput;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoWinningSystemTest {
    private static final OutputView outputView = new OutputView(new ConsoleOutput());
    private static final InputView inputView = new InputView(new ConsoleInput());
    private static final PickNumbers pickNumbers = new RandomPicker();


    @DisplayName("로또당첨시스템 생성자에서는 InputView 가 null 이면 예외가 발생한다")
    @Test
    void LottoWinningSystem_생성자_InputView_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningSystem(null, outputView, pickNumbers));
    }

    @DisplayName("로또당첨시스템 생성자에서는 OutputView 가 null 이면 예외가 발생한다")
    @Test
    void LottoWinningSystem_생성자_OutputView_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningSystem(inputView, null, pickNumbers));
    }

    @DisplayName("로또당첨시스템 생성자에서는 pickNumbers 가 null 이면 예외가 발생한다")
    @Test
    void LottoWinningSystem_생성자_PickNumbers_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningSystem(inputView, outputView, null));
    }
}
