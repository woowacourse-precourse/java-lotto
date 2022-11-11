package lotto.util;

import lotto.common.InputErrors;
import lotto.ui.dto.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "당첨 번호 입력 검증 테스트")
class WinNumbersValidatorTest {

    private static final String ERROR_PREFIX = "[ERROR]";
    private final WinNumbersValidator validator = new WinNumbersValidator();

    @Test
    public void 값은_존재_해야_한다() {
        String userInput = " ";

        String containedMessage = InputErrors.BLANK.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 값은_숫자만_가능하다() {
        String userInput = "1,a,v,c";

        String containedMessage = InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 숫자_사이에는_구분자만_존재할_수_있다() {
        String userInput = "1, 2, 3, 4, 5, 6";

        String containedMessage = InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 지정된_구분자로_구분_되어야_한다() {
        String userInput = "1|2|3|4|5|6";

        String containedMessage = InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구분자는_반드시_존재해야_한다() {
        String userInput = "1 2 3 4 5 6";

        String containedMessage = InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 구분자는_연속_될_수_없다() {
        String userInput = "1,,2,3,4,5,6";

        String containedMessage = InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 당첨_번호는_6자리_이다() {
        String userInput = "1,2,3";

        String containedMessage = InputErrors.WIN_NUMBER_MISMATCH_SIZE.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 당첨_번호는_45보다_작거나_같은_숫자이다() {
        String userInput = "1,2,3,4,5,46";

        String containedMessage = InputErrors.WIN_NUMBER_OUT_OF_RANGE.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 당첨_번호는_1보다_크거나_같은_숫자이다() {
        String userInput = "0,1,2,3,4,5";

        String containedMessage = InputErrors.WIN_NUMBER_OUT_OF_RANGE.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }

    @Test
    public void 당첨_번호는_중복_되지_않는다() {
        String userInput = "1,1,2,3,4,5";

        String containedMessage = InputErrors.WIN_NUMBER_DUPLICATED.getMessage();
        assertIllegalArgumentException(userInput, containedMessage);
    }


    private void assertIllegalArgumentException(String userInput, String containedMessage) {
        Assertions.assertThatThrownBy(() -> generateWinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(containedMessage);
    }

    private void generateWinNumbers(String userInput) {
        new WinNumbers(userInput, validator);
    }

}