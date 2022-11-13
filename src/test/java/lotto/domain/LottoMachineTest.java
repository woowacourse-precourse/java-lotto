package lotto.domain;

import handler.console.ConsoleInput;
import handler.console.ConsoleOutput;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoMachineTest {
    private static final OutputView outputView = new OutputView(new ConsoleOutput());
    private static final InputView inputView = new InputView(new ConsoleInput());
    private static final PickNumbers pickNumbers = new RandomPicker();


    @DisplayName("로또 머신 생성자에서는 InputView 가 null 이면 예외가 발생한다")
    @Test
    void case1() {
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(null, outputView, pickNumbers));
    }

    @DisplayName("로또 머신 생성자에서는 OutputView 가 null 이면 예외가 발생한다")
    @Test
    void case2() {
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(inputView, null, pickNumbers));
    }

    @DisplayName("로또 머신 생성자에서는 pickNumbers 가 null 이면 예외가 발생한다")
    @Test
    void case3() {
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(inputView, outputView, null));
    }
}
