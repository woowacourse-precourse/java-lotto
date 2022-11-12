package lotto.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.lottomachine.LottoMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private static final String ERROR = "[ERROR]";
    private static LottoMachine lottoMachine;
    private OutputStream out;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("로또구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByWrongUnits() {
        // given
        String userAmount = "1200";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when
        lottoMachine.buyLotto();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("로또구입 금액은 숫자가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByNotNumber() {
        // given
        String userAmount = "1200a";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when
        lottoMachine.buyLotto();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }
}
