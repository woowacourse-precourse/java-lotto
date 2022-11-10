package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer = new Customer();

    @Test
    void 금액_입력_및_확인() {

        String money = "10000";
        InputStream inputStream = new ByteArrayInputStream(money.getBytes());
        System.setIn(inputStream);

        customer.payMoney();

        assertThat(Integer.parseInt(money)).isEqualTo(customer.getMoney());

    }

}