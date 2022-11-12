package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

class PlayerTest {
    private Player player = new Player();

    /**
     * 금액 입력 테스트
     */
    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyInputNotDividedException() {
        ScannerInput("1200");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputMoney();
        });
    }

    @DisplayName("1000원으로 나누어 떨어지면 통과한다.")
    @Test
    void moneyInputDividedException() {
        ScannerInput("15000");
        player.inputMoney();
        int purchaseNumber = player.getPurchaseNumber();
        Assertions.assertEquals(purchaseNumber, 15000);
    }

    @DisplayName("0원을 입력할시 예외가 발생한다.")
    @Test
    void moneyInputZeroException() {
        ScannerInput("0");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputMoney();
        });
    }

    /**
     * 당첨번호 입력 테스트
     */
    @DisplayName("6자리 이상의 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLengthOutOfBoundInputException() {
        ScannerInput("1,2,3,4,5,6,7");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputPrizeNumbers();
        });
    }

    @DisplayName("6자리 이하의 당첨 번호를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLessLengthInputException() {
        ScannerInput("1,2,3,4");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputPrizeNumbers();
        });
    }

    @DisplayName("쉼표로 구분하지 않으면 예외가 발생한다.")
    @Test
    void prizeNumbersNotSplitCommaInputException() {
        ScannerInput("1234");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputPrizeNumbers();
        });
    }

    @DisplayName("45가 넘는 숫자를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersOverRangeInputException() {
        ScannerInput("1,2,4,5,7,46");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputPrizeNumbers();
        });
    }

    @DisplayName("1보다 작은 숫자를 입력하면 예외가 발생한다.")
    @Test
    void prizeNumbersLessRangeInputException() {
        ScannerInput("1,2,4,-1,5,4,6");
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputPrizeNumbers();
        });
    }

    @DisplayName("1~45 사이의 6자리 숫자를 쉼표로 구분하여 입력하면 통과한다.")
    @Test
    void prizeNumbersInput() {
        ScannerInput("1,2,4,5,6,7");
        player.inputPrizeNumbers();
        List<Integer> prizeNumbers = player.getPrizeNumbers();
        Assertions.assertEquals(prizeNumbers.size(), 6);
        Assertions.assertTrue(prizeNumbers.containsAll(List.of(1,2,4,5,6,7)));
    }

    private void ScannerInput(String systemInput) {
        InputStream input = generateUserInput(systemInput);
        System.setIn(input);
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}