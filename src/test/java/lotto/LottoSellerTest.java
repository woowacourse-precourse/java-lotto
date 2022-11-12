package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static lotto.Constant.ERROR_INPUT_PAY_AMOUNT;
import static lotto.Constant.MESSAGE_NUMBER_OF_TICKET_IS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoSellerTest {
    private LottoSeller purchase;

    @BeforeEach
    void setUp() {
        purchase = new LottoSeller();

    }

    @Test
    void 구입금액에_따른_로또개수_테스트() {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        purchase.getPayAmount();
        purchase.countTicket();
        assertThat(out.toString()).isEqualTo(8 + MESSAGE_NUMBER_OF_TICKET_IS);
    }
    @Test
    void 예외_테스트() {

        String input = "1100";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        purchase.getPayAmount();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                purchase.countTicket());
        assertEquals(ERROR_INPUT_PAY_AMOUNT, exception.getMessage());
    }
}