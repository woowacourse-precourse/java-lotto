package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreTest {
    private Store testStore;

    @BeforeEach
    void setUp() {
        testStore = new Store();
    }

    @Test
    @DisplayName("로또를 파는 메서드가 새로운 Customer 객체를 생성한다.")
    void checkSellLottoToCustomerCreateNewCustomer() {
        //given
        String paidMoney = "3000";
        InputStream in = new ByteArrayInputStream(paidMoney.getBytes());
        System.setIn(in);

        //when, then
        assertThatNoException().isThrownBy(testStore::sellLottoToCustomer);
    }

    @Test
    @DisplayName("유효한 당첨번호와 보너스 번호를 입력받고 유효성 검사를 통과한다.")
    void checkPickWinningNumberWithBonusNumberByValidInput() {
        //given
        String validInput = "1,2,3,4,5,6\n7";
        InputStream in = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(in);

        //when, then
        assertThatNoException().isThrownBy(()->testStore.pickWinningNumberWithBonusNumber());
    }
}
