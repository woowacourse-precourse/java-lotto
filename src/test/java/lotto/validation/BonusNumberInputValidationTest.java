package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberInputValidationTest {
    private BonusNumberInputValidation bonusNumberInputValidation;

    @BeforeEach
    public void initialize() {
        bonusNumberInputValidation = new BonusNumberInputValidation();
    }

    @DisplayName("보너스 번호 입력 시 숫자가 아닌 문자가 입력될 경우, 예외가 발생한다.")
    @Test
    void validateInputIsIntegerTest() {
        assertThatThrownBy(() -> bonusNumberInputValidation.validateInputIsInteger("b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 예측 번호와 중복된 경우, 예외가 발생한다.")
    @Test
    void validateNoDuplicationWithPredictionNumbersTest() {
        List<Integer> predictionNumbers = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> bonusNumberInputValidation.validateNoDuplicationWithPredictionNumbers(predictionNumbers, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작거나 45보다 큰 경우, 예외가 발생한다.")
    @Test
    void validateNumberRangeTest() {
        assertThatThrownBy(() -> bonusNumberInputValidation.validateNumberRange("50"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
