package lotto;

import org.junit.jupiter.api.Test;
import lotto.util.InputUtil;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputUtilTest {

    InputUtil inputUtil;

    @BeforeEach
    void beforeEach() {
        inputUtil = new InputUtil();
    }

    @Test
    void 잘못된_구입금액_입력() {
        String[] inputs = {"100", "1001", "100100", "aa"};
        for (String input : inputs) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> inputUtil.checkValidationMoney(input));
        }
    }
}
