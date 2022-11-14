package lotto;

import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class StoreTest {

    //우테코 라이브러리 믿고쓰면 되는거겠죠?...

    @DisplayName("6개의 1~45의 숫자가 생성되면 통과")
    @Test
    void testPick6UniqueNumber() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6);
        int nSize = numbers.size();
        assertThat(nSize).isEqualTo(6);
        for(int i=0; i<6; i++){
            assertThat(numbers.get(0)).isBetween(1,45);
        }
    }

    @DisplayName("사용자의 금액에 맞는 개수를 반환하면 통과")
    @Test
    void countLottoTest() {
        Customer customer = new Customer("5000");
        Store store = new Store(customer);
        assertThat(store.countLotto()).isEqualTo(5);
    }

    @DisplayName("정렬된 로또를 생성하면 통과")
    @Test
    void makeLottoTest() {
        Customer customer = new Customer("5000");
        Store store = new Store(customer);
        Lotto lotto = store.makeLotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("로또가 DB에 잘 저장되면 통과")
    @Test
    void saveLottoTest() {
        Customer customer = new Customer("5000");
        Store store = new Store(customer);
        for(int i=0; i<3; i++){
            Lotto lotto = store.makeLotto();
            store.saveLotto(lotto);
        }

        assertThat(DB.getTableSize()).isEqualTo(3);
    }

    @DisplayName("로또를 구매해서 DB에 저장하고 예상했던 개수와 일치하면 통과")
    @Test
    void buyLottoTest() {
        Customer customer = new Customer("5000");
        Store store = new Store(customer);
        store.buy();
        assertThat(DB.getTableSize()).isEqualTo(5);
    }
}




