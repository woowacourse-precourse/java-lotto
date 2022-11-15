package lotto;

import lotto.input.TotalPriceGetter;
import lotto.input.validation.TotalPriceValidator;
import lotto.input.validation.code.TotalPriceValidationCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TotalPriceGetterValidatorTest {
    @DisplayName("사용자가 올바른 형식의 구입 금액을 입력할 경우, 이를 정수로 변환한 값을 반환한다.")
    @Test
    void convertValidUserInputForTotalPriceToIntegerTest() {
        TotalPriceGetter totalPriceGetter = new TotalPriceGetter();

        String[] validTotalPrices = new String[]{"1000", "2000", "3000", "1000000", "500000", "35000"};
        List<Integer> result = new ArrayList<>();
        List<Integer> validResult = new ArrayList<>(List.of(1000, 2000, 3000, 1000000, 500000, 35000));

        for (String price : validTotalPrices) {
            System.setIn(new ByteArrayInputStream((price).getBytes()));
            result.add(totalPriceGetter.getTotalPriceFromUser());
        }

        assertThat(result.size()).isEqualTo(6);
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).isEqualTo(validResult.get(i));
        }
    }

    // UserInputValidator 테스트
    @DisplayName("사용자가 입력한 구입금액 형식에 따라 올바른 검증결과 코드를 반환한다.")
    @Test
    void userInputValidator_IntegratedTest() {
        TotalPriceValidator totalPriceValidator = new TotalPriceValidator();
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("1000"))
                .isEqualTo(TotalPriceValidationCode.VALID_NUMBER);
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("3000"))
                .isEqualTo(TotalPriceValidationCode.VALID_NUMBER);
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("500000"))
                .isEqualTo(TotalPriceValidationCode.VALID_NUMBER);
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("01000"))
                .isEqualTo(TotalPriceValidationCode.INVALID_NUMBER_FORMAT);
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("+000"))
                .isEqualTo(TotalPriceValidationCode.INVALID_NUMBER_FORMAT);
        assertThat(totalPriceValidator.getUserTotalPriceInputValidationCode("100"))
                .isEqualTo(TotalPriceValidationCode.INVALID_NUMBER);
    }

    @DisplayName("입력된 구입 금액 문자열이 올바르지 않을 경우 예외가 발생한다.")
    @Test
    void userInputValidator_ExceptionTest() {
        TotalPriceGetter totalPriceGetter = new TotalPriceGetter();
        assertThatThrownBy(() -> totalPriceGetter.throwExceptionIfUserInputTotalPriceNotValid("total price"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> totalPriceGetter.throwExceptionIfUserInputTotalPriceNotValid("+000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> totalPriceGetter.throwExceptionIfUserInputTotalPriceNotValid("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void isUserInputValidNumberFormatTest() {
        TotalPriceValidator totalPriceValidator = new TotalPriceValidator();

        String[] invalidNumberFormatStrings = new String[]{"", "1,000", "1000.00", "30+00", "java", null};
        for (String string : invalidNumberFormatStrings) {
            assertThat(totalPriceValidator.isUserInputValidNumberFormat(string)).isEqualTo(false);
        }

        String[] validNumberFormatStrings = new String[]{"1000", "9999", "00012340", "500", "0", "-500", "+500"};
        for (String string : validNumberFormatStrings) {
            assertThat(totalPriceValidator.isUserInputValidNumberFormat(string)).isEqualTo(true);
        }
    }

    @Test
    void isFirstLetterBetweenOneAndNineTest() {
        TotalPriceValidator totalPriceValidator = new TotalPriceValidator();

        String[] validInputs = new String[]{"1000", "9999", "500", "500", "500"};
        for (String string : validInputs) {
            assertThat(totalPriceValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(true);
        }

        String[] invalidInputs = new String[]{"0", "0100", "00000123", "+500", "-500"};
        for (String string : invalidInputs) {
            assertThat(totalPriceValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(false);
        }
    }

    @Test
    void isValueMoreThanOrEqualToOneThousandTest() {
        TotalPriceValidator totalPriceValidator = new TotalPriceValidator();

        int[] validValues = new int[]{1000, 2000, 3000, 4000, 5000};
        for (int value : validValues) {
            assertThat(totalPriceValidator.isValueMoreThanOrEqualToOneThousand(value)).isEqualTo(true);
        }

        int[] invalidValues = new int[]{-1000, 0, 500, 30};
        for (int value : invalidValues) {
            assertThat(totalPriceValidator.isValueMoreThanOrEqualToOneThousand(value)).isEqualTo(false);
        }
    }

    @Test
    void isValueMultipleOfOneThousandTest() {
        TotalPriceValidator totalPriceValidator = new TotalPriceValidator();

        int[] validValues = new int[]{1000, 2000, 3000, 4000, 5000};
        for (int value : validValues) {
            assertThat(totalPriceValidator.isValueMultipleOfOneThousand(value)).isEqualTo(true);
        }

        int[] invalidValues = new int[]{-1000, 0, 1001, 2002};
        for (int value : invalidValues) {
            assertThat(totalPriceValidator.isValueMultipleOfOneThousand(value)).isEqualTo(false);
        }
    }
}
