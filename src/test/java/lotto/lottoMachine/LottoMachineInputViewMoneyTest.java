package lotto.lottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.lottomachine.LottoMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineInputViewMoneyTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static LottoMachine lottoMachine;


    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("로또구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByWrongUnits() {
        // given
        String userAmount = "1200";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when then
        assertThatThrownBy(() -> lottoMachine.buyLotto())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또구입 금액은 숫자가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByNotNumber() {
        // given
        String userAmount = "1200a";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when then
        assertThatThrownBy(() -> lottoMachine.buyLotto())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}
