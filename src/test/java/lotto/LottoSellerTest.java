package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @Test
    void tekeMoneyTest() {
        String money = "9326";
        LottoSeller tester = new LottoSeller();

        InputStream input = new ByteArrayInputStream(money.getBytes());
        tester.takeMoney();
        System.setIn(input);
        assertThat(tester.money).isEqualTo(9326);
        assertThat(tester.piece).isEqualTo(9);
        assertThat(tester.change).isEqualTo(326);
    }

    @Test
    void makeLottoBundleTest() {
        LottoSeller tester = new LottoSeller(6825);

        tester.makeLottoBundle();
        assertThat(tester.bundle.size()).isEqualTo(6);
    }
}
