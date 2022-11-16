package lotto;

import lotto.controller.Dispatch;
import lotto.controller.UserController;
import lotto.domain.lotto.LottoInfo;
import lotto.domain.user.User;
import lotto.service.StoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StoreTest {
    LottoConfig lottoConfig = new LottoConfig();
    StoreService storeService = lottoConfig.storeService();
    UserController userController = lottoConfig.userController();
    Dispatch dispatch = new Dispatch(lottoConfig);

    @Test
    @DisplayName("금액 입력 테스트")
    void getMoney(){
        int money = 8000;
        User user = new User(money);

        assertThat(user.getMoney()).isEqualTo(money);
    }

    @Test
    @DisplayName("금액 입력 예외 테스트")
    void getMoneyException(){
        assertThatThrownBy(() -> dispatch.convertMoney("8100"))
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

    @Test
    @DisplayName("로또 구매 개수 테스트2")
    void numberOfLotto2(){
        int money = 8000;
        User user = new User(money);
        userController.buyLotto(user);

        assertThat(user.getLotto().size())
                .isEqualTo(money / LottoInfo.PRICE.getValue());
    }
}
