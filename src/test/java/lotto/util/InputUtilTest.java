package lotto.util;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputUtilTest {

    List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);

    @Test
    void 올바른_구입금액_입력() {
        String input = "1000";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationMoney(input));
    }

    @Test
    void 잘못된_구입금액_입력() {
        String[] inputs = {"100", "1001", "100100", "aa"};
        for (String input : inputs) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> ExceptionHandler.checkValidationMoney(input));
        }
    }

    @Test
    void 올바른_보너스번호_입력() {
        String input = "7";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

    @Test
    void 잘못된_보너스번호_입력_중복() {
        String input = "6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

    @Test
    void 잘못된_보너스번호_입력_문자() {
        String input = "a";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

    @Test
    void 올바른_당첨번호_입력() {
        String input = "1,2,3,4,5,6";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @Test
    void 잘못된_당첨번호_입력_콤마아닌경우() {
        String input = "1,2,3.4,5,6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @Test
    void 잘못된_당첨번호_입력_문자() {
        String input = "1,2,3,a,5,6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @Test
    void 잘못된_당첨번호_입력_중복() {
        String input = "1,2,3,4,5,5";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }
}
