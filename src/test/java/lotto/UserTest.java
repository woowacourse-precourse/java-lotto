package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @ParameterizedTest
    @CsvSource({"1000,true","1001,false"})
    void userPayMoneyTest(String input, boolean expectedException) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        User user = new User();

        if (expectedException) {
            assertThatCode(() -> user.payMoney())
                    .doesNotThrowAnyException();
        }
        if (!expectedException) {
            assertThatThrownBy(() -> user.payMoney())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @CsvSource({"1000,1","2000,2","18000,18"})
    void userBuyLottoTest(String input, int lottoCount) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        User user = new User();
        user.payMoney();
        user.buyLotto();

        assertThat(user.getLottoCount()).isEqualTo(lottoCount);
    }
}