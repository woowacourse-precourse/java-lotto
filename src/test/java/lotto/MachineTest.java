package lotto;

import lotto.machine.Lotto;
import lotto.machine.Machine;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MachineTest {
    Machine machine = new Machine();

    @Test
    void Money_Insert_test() {
        String input = "6000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        machine.Insert();
        assertThat(out.toString().trim()).contains("구입금액을 입력해 주세요.", "6000");
    }

    @Test
    void Money_range_error_test() {
        String input = "6500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> machine.Insert())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Money_form_error_test() {
        String input = "609f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> machine.Insert())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
