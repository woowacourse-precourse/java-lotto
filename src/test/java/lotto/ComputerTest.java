package lotto;

import lotto.model.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {

    @Test
    void 구입금액이_1000원_단위가_아닐_떄_test() {
        Computer computer = new Computer();

        assertThatThrownBy(() -> computer.validate(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
