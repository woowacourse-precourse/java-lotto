package lotto;

import lotto.model.Player;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    static OutputView outputView;
    static OutputStream outputStream;

    @BeforeAll
    static void setup() {

        outputView = new OutputView();
    }

    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPlayerByNotDividedBy1000() {
        initOutputStream();
        Player player = new Player("5050");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("구입 금액이 음수면 예외가 발생한다.")
    @Test
    void createPlayerByMinusValue() {
        initOutputStream();
        Player player = new Player("-5000");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("구입 금액이 규격 이외면 예외가 발생한다.")
    @Test
    void createPlayerByInvalidValue() {
        initOutputStream();
        Player player = new Player("이상한값");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("티켓 개수 = 구입 금액 / 1000 이어야 한다.")
    @Test
    void testTicketNumberEqualsPurchaseAmountDividedBy1000() {
        initOutputStream();
        Player player = new Player("10000");
    }
}
