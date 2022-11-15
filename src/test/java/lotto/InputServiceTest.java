package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    @Test
    void 금액_예외(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new InputService().moneyValidate("1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 금액_예외_숫자아님(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new InputService().moneyValidate("aaa"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

}