package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("숫자가 아닌 값 입력한 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"가나다", "1000j", "-1000"})
    void inputValueByNonNumericValue(String inputValue) {
        assertThatThrownBy(() -> inputView.validateValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}