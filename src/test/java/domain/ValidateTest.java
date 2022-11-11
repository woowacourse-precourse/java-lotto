package domain;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    private static final Validate validate = new Validate();

    @Test
    public void 입력값_예외처리() throws Exception {
        //given
        String[] inputs = {"str54", "123", "1024"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> validate.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}