package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    @Test
    @DisplayName("콤마가 들어간 6자리 당첨 번호 성공")
    void testSplit() {
        String string = "1,2,3,4,5,6";

        List<Integer> integerList = Converter.splitFromString(string);

        assertThat(integerList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("1자리 당첨 번호 6자리가 아니여서 실패")
    void testSplitFail() {
        String string = "123456";
        List<Integer> integerList = Converter.splitFromString(string);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateSplitSize(integerList));
    }

    @Test
    @DisplayName("중복된 당첨 숫자라서 실패")
    void testDuplicateFail() {
        String string = "1,1,1,1,1,1";
        List<Integer> integerList = Converter.splitFromString(string);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateDuplicateWinningNumbers(integerList));
    }

    @Test
    @DisplayName("보너스 숫자가 당첨 숫자에 있어서 실패")
    void testDuplicateBonusNumberFail() {
        String string = "1,2,3,4,5,6";
        List<Integer> integerList = Converter.splitFromString(string);

        int bonusNumber = 1;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateDuplicateBonusNumber(integerList, bonusNumber));
    }


    @Test
    @DisplayName("숫자가 아닌 값이 들어와서 실패")
    void testDigitFail() {
        String string = "가,홍시_카리나,123,12,1,2";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Converter.splitFromString(string));
    }

    @Test
    @DisplayName("공백 포함할 때 성공")
    void testSpace() {
        String string = "00001,02, 03,04 , 05 ,06";
        List<Integer> integers = Converter.splitFromString(string);
        InputValidator.validateWinningNumbersRange(integers);
    }
}
