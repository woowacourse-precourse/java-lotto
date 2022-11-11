package lotto;

import org.junit.jupiter.api.Test;
import lotto.util.InputUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputUtilTest {

    InputUtil inputUtil = new InputUtil();
    List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);

    @Test
    void 올바른_구입금액_입력() {
        String input = "1000";
        assertThatNoException()
                .isThrownBy(() -> inputUtil.checkValidationMoney(input));
    }

    @Test
    void 잘못된_구입금액_입력() {
        String[] inputs = {"100", "1001", "100100", "aa"};
        for (String input : inputs) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> inputUtil.checkValidationMoney(input));
        }
    }

    @Test
    void 올바른_보너스번호_입력() {
        String input = "7";
        assertThatNoException()
                .isThrownBy(() -> inputUtil.checkValidationBonusNumber(input, lottoNumbers));
    }

    @Test
    void 잘못된_보너스번호_입력1() {
        String input = "6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputUtil.checkValidationBonusNumber(input, lottoNumbers));
    }

    @Test
    void 잘못된_보너스번호_입력2() {
        String input = "a";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputUtil.checkValidationBonusNumber(input, lottoNumbers));
    }
}
