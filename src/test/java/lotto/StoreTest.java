package lotto;

import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class StoreTest {
    Customer customer;
    Store store;
    Lotto lotto;
    StoreTest(){
        this.customer = new Customer("5000");
        this.store = new Store(customer);
        this.lotto = store.makeLotto();
    }

    @Test
    void testPick6UniqueNumber() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6);
        int nSize = numbers.size();
        assertThat(nSize).isEqualTo(6);
        for(int i=0; i<6; i++){
            assertThat(numbers.get(0)).isBetween(1,45);
        }
    }

    @Test
    void countLottoTest() {
        assertThat(store.countLotto()).isEqualTo(5);
    }

    @Test
    void makeLottoTest() {
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers()).isSorted();
    }

   @Test
    void saveLottoTest() {
        for(int i=0; i<3; i++){
            Lotto lotto = store.makeLotto();
            store.saveLotto(lotto);
        }
        assertThat(DB.getTableSize()).isEqualTo(3);
       DB.init();
   }

    @Test
    void buyLottoTest() {
        store.buy();
        assertThat(DB.getTableSize()).isEqualTo(5);
        DB.init();
    }
}




