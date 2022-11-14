package lotto;

import lotto.domain.lotto.LottoInfo;
import lotto.domain.user.User;
import lotto.service.StoreService;
import lotto.view.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StoreTest {
    Store store = new Store();

    StoreService storeService = new StoreService();

    @Test
    @DisplayName("금액 입력 테스트")
    void getMoney(){
        System.out.println(store.sellingLotto());

        int money = Integer.parseInt("8000");
        User user = new User(money);

        assertThat(user.getMoney()).isEqualTo(money);
    }

    @Test
    @DisplayName("금액 입력 예외 테스트")
    void getMoneyException(){
        System.out.println(store.sellingLotto());

        int money = Integer.parseInt("8100");

        assertThatThrownBy(() -> new User(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void generateLotto(){
        assertThatCode(() -> storeService.sellLotto())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 구매 개수 테스트")
    void numberOfLotto(){
        int money = 8000;

        assertThat(storeService.numberOfSoldLotto(money))
                .isEqualTo(money / LottoInfo.PRICE.getValue());
    }

}
