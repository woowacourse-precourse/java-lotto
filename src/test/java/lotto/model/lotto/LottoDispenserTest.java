package lotto.model.lotto;

import lotto.model.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoDispenserTest {

    @Test
    void 로또번호_구매_갯수_검증() {
        //given
        Customer customer = new Customer(8000);
        //when
        customer = LottoDispenser.purchase(customer, 8000);

        //then
        assertThat(customer.getCntOfLottos()).isEqualTo(8);
    }
}