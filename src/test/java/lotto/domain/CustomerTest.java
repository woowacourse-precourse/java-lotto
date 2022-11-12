package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private final static Customer customer = new Customer();
    private final static String money = "15000";

    @BeforeAll
    static void 금액_입력() {

        InputStream inputStream = new ByteArrayInputStream(money.getBytes());
        System.setIn(inputStream);

        customer.payMoney();

    }

    @Test
    void 금액_확인() {

        assertThat(Integer.parseInt(money)).isEqualTo(customer.getMoney());

    }

    @Test
    void 로또_구매() {

        int result = customer.getMoney() / 1000;
        customer.buyLotto();

        assertThat(customer.getHasLotto()).isEqualTo(result);

    }

}