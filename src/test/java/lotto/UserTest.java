package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    private final static int PRICE_OF_LOTTO = 1000;

    @DisplayName("유저 생성자 테스트")
    @Test
    public void userConstructorTest() {
        // given
        int buyingPrice = 1000;

        // when
        User user = new User(buyingPrice);

        // then
        assertThat(user.getBuyingPrice()).isEqualTo(buyingPrice);
    }

    @DisplayName("유저 로또 구매 테스트")
    @Test
    public void userSetLottosTest() {
        // given
        int buyingPrice = 3000;
        User user = new User(buyingPrice);

        // when
        user.setLottos(user.getBuyingPrice());

        // then
        assertThat(user.getLottos().size()).isEqualTo(buyingPrice / PRICE_OF_LOTTO);
    }

    @DisplayName("로또 우승 상금 테스트")
    @Test
    public void winningPriceTest() {
        // given
        User user = new User(1000);
        int earnMoneyByLotto = 3000;

        // when
        user.addWinningPrice(earnMoneyByLotto);

        // then
        assertThat(user.getWinningPrice()).isEqualTo(earnMoneyByLotto);
    }
}
