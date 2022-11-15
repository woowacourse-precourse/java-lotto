package domain;

import domain.Money.Money;
import domain.Money.MoneyController;
import domain.UserLotto.UserLotto;
import domain.UserLotto.UserLottoController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {
    MoneyController moneyController = new MoneyController();
    UserLottoController userLottoController = new UserLottoController();

    @Test
    void 랜덤_로또번호_생성_테스트() {
        Money money = new Money(5000);
        int purchaseNumber = moneyController.getAvailablePurchaseNumber(money);
        UserLotto userLotto = userLottoController.createUserLotto(purchaseNumber);

        assertThat((userLotto.getUserLottoSize() == purchaseNumber)).isTrue();
    }
}