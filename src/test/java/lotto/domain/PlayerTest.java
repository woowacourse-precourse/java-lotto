package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest extends NsTest {
    private Player player = new Player();
    private static final String ERROR_MESSAGE = "[ERROR]";

    /**
     * 금액 입력 테스트
     */
    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyInputNotDividedException() {
        assertSimpleTest(() -> {
            runException("1020");
            assertThat(output()).contains(ERROR_MESSAGE);
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
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("문자 입력할시 예외가 발생한다.")
    @Test
    void notMoneyInputZeroException() {
        assertSimpleTest(() -> {
            runException("AA");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private void ScannerInput(String systemInput) {
        InputStream input = generateUserInput(systemInput);
        System.setIn(input);
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}