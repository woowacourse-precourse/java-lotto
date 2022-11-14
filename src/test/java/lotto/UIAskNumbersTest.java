package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import camp.nextstep.edu.missionutils.test.NsTest;

class UIAskNumbersTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("입력값들이 ,구분자로 나누어지지 않았을 때 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"10 20 30 40 41 42 43", "1.2.3.4.5.6"})
    void ShouldBeSplitedByComma(String input) {
        assertThatThrownBy(() -> Application.validateSplit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
	
	@DisplayName("입력값들이 숫자가 아닐 경우 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"10,a,b,21,22,33", "1,3,%,2,3,."})
    void ShouldBeNumber(String input) {
		String[] inputStr = input.split(",");

        assertThatThrownBy(() -> Application.validateLottoNumber(inputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
	
	@DisplayName("입력값들이 1-45 사이의 숫자가 아닐 경우 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"10,22,33,44,55,45", "1,2,3,4,99,6"})
    void ShouldBeNumbersOneToFortyFive(String input) {
		String[] inputStr = input.split(",");
		
        assertThatThrownBy(() -> Application.validateLottoNumber(inputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

	@Override
	protected void runMain() {
		Application.main(new String[]{});
		
	}
	
}
