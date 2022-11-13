package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class InputTest {

    @Test
    void checkMoneyTest() {
        Input input=new Input();

        assertThatThrownBy(() -> input.checkMoney("1000j"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkMoney("12400"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}