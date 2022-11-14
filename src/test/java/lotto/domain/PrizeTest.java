package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

class PrizeTest {
    private Prize prize = new Prize();

    /**
     * 당첨번호 입력 테스트
     */
    @DisplayName("6자리 이상의 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLengthOutOfBoundInputExceptionTest() {
        ScannerInput("1,2,3,4,5,6,7");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputPrizeNumbers();
        });
    }

    @DisplayName("6자리 이하의 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLessLengthInputExceptionTest() {
        ScannerInput("1,2,3,4");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputPrizeNumbers();
        });
    }

    @DisplayName("쉼표로 구분하지 않으면 예외가 발생한다.")
    @Test
    void prizeNumbersNotSplitCommaInputExceptionTest() {
        ScannerInput("1234");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputPrizeNumbers();
        });
    }

    @DisplayName("45가 넘는 숫자를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersOverRangeInputExceptionTest() {
        ScannerInput("1,2,4,5,7,46");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputPrizeNumbers();
        });
    }

    @DisplayName("1보다 작은 숫자를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLessRangeInputExceptionTest() {
        ScannerInput("1,2,4,-1,5,4,6");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputPrizeNumbers();
        });
    }

    @DisplayName("1~45 사이의 6자리 숫자를 쉼표로 구분하여 입력하면 통과한다.")
    @Test
    void prizeNumbersInputTest() {
        ScannerInput("1,2,4,5,6,7");
        prize.inputPrizeNumbers();
        List<Integer> prizeNumbers = prize.getPrizeNumbers();
        Assertions.assertEquals(prizeNumbers.size(), 6);
        Assertions.assertTrue(prizeNumbers.containsAll(List.of(1, 2, 4, 5, 6, 7)));
    }

    /**
     * 보너스 숫자 입력 테스트
     */
    @DisplayName("1~45 사이가 아닌 숫자를 입력하면 에러가 발생한다.")
    @Test
    void bonusNumbersOverRangeInputExceptionTest() {
        ScannerInput("46");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputBonusNumber();
        });
    }

    @DisplayName("숫자를 입력하지 않으면 오류가 발생한다.")
    @Test
    void bonusNumbersNotNumberInputExceptionTest() {
        ScannerInput("A");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            prize.inputBonusNumber();
        });
    }

    @DisplayName("1~45사이의 올바른 숫자를 입력하면 통과한다.")
    @Test
    void bonusNumbersInputTest() {
        ScannerInput("5");
        prize.inputBonusNumber();
        int bonusNumber = prize.getBonusNumber();
        Assertions.assertEquals(bonusNumber, 5);
    }

    private void ScannerInput(String systemInput) {
        InputStream input = generateUserInput(systemInput);
        System.setIn(input);
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}