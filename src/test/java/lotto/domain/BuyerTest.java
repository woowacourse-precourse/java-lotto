package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class BuyerTest {
    @Test
    void 구매한_로또_갯수_테스트(){
        // given
        String testBuyerMoney = "6000";
        int expected = 6;

        // when
        Buyer testBuyer = new Buyer();
        InputStream in = new ByteArrayInputStream(testBuyerMoney.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        testBuyer.buy();

        // then
        assertThat(testBuyer.getHaveCount()).isEqualTo(expected);
    }


}
