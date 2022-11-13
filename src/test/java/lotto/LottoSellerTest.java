package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @Test
    void tekeMoneyTest() {
        String money = "9326";
        LottoSeller tester = new LottoSeller();

        tester.takeMoney();
        InputStream input = new ByteArrayInputStream(money.getBytes());
        System.setIn(input);
        assertThat(tester.money).isEqualTo(9326);
        assertThat(tester.piece).isEqualTo(9);
        assertThat(tester.change).isEqualTo(326);
    }
}
