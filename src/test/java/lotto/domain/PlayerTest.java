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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.inputMoney();
        });
    }

    private void ScannerInput(String systemInput) {
        InputStream input = generateUserInput(systemInput);
        System.setIn(input);
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}