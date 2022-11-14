package lotto;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @Test
    void tekeMoneyTest() {
        String money = "9326";
        LottoSeller tester = new LottoSeller();

        InputStream input = new ByteArrayInputStream(money.getBytes());
        System.setIn(input);
        tester.takeMoney();
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

    @Test
    void showBundleTest() {
        Lotto lotto1 = new Lotto(List.of(43,21,30,42,33,1));
        Lotto lotto2 = new Lotto(List.of(23,5,8,7,43,15));
        LottoSeller tester = new LottoSeller(List.of(lotto1, lotto2));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        tester.showBundle();
        assertThat(out.toString()).isEqualTo("[1, 21, 30, 33, 42, 43]\r\n[5, 7, 8, 15, 23, 43]\r\n");
    }
}
