package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class InputTest {
    Input input=new Input();
    @Test
    void checkMoneyTest() {
        assertThatThrownBy(() -> input.checkMoney("1000j"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkMoney("12400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkLottoTest() {
        assertThatThrownBy(() -> input.checkLotto("33j"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkLotto("j"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkLotto("#"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkLotto("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkLotto("90"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWinningTest() {
        assertThatThrownBy(() -> input.checkWinningLotto("dsf"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkWinningLotto("ds,12,df,4"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkWinningLotto("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.checkWinningLotto("1,2,3,4,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}