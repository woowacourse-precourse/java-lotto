package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("에측 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateNoDuplicateNumbersTest() {
        assertThatThrownBy(() -> predictionNumbersInputValidation.validateNoDuplicateNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예측 번호 중 1보다 작거나 45보다 큰 값이 있으면 예외가 발생한다.")
    @Test
    void validateNumbersRangeTest() {
        assertThatThrownBy(() -> predictionNumbersInputValidation.validateNumbersRange(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}