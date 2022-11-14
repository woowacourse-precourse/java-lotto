package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PredictionNumbersInputValidationTest {
    private PredictionNumbersInputValidation predictionNumbersInputValidation;

    @BeforeEach
    public void initialize() {
        predictionNumbersInputValidation = new PredictionNumbersInputValidation();
    }

    @DisplayName("예측 번호 입력 시 쉼표로 구분되지 않거나 숫자가 아닌 문자가 입력될 경우, 예외가 발생한다.")
    @Test
    void validateInputFormatTest() {
        assertThatThrownBy(() -> predictionNumbersInputValidation.validateInputFormat("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}