package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreTest {
    @Test
    @DisplayName("로또를 파는 메서드가 새로운 Customer 객체를 생성한다.")
    void checkSellLottoToCustomerCreateNewCustomer() {
        //given
        Store testStore = new Store();
        String paidMoney = "3000";
        InputStream in = new ByteArrayInputStream(paidMoney.getBytes());
        System.setIn(in);

        //when, then
        assertThatNoException().isThrownBy(testStore::sellLottoToCustomer);
    }
}
