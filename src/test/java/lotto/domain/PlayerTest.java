package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class PlayerTest {
    private Player player = new Player();

    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyInputNotDividedException() {
        InputStream input = generateUserInput("1200");
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputMoney();
        });
    }

    @DisplayName("1000원으로 나누어 떨어지면 통과한다.")
    @Test
    void moneyInputDividedException() {
        InputStream input = generateUserInput("15000");
        System.setIn(input);
        player.inputMoney();
        int purchaseNumber = player.getPurchaseNumber();
        Assertions.assertEquals(purchaseNumber, 15000);
    }

    @DisplayName("0원을 입력할시 예외가 발생한다.")
    @Test
    void moneyInputZeroException() {
        InputStream input = generateUserInput("0");
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.inputMoney();
        });
    }


    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}