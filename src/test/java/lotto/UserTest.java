package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domian.User;
import lotto.domian.UserSingleLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserTest {

    private static final int LOTTO_MINIMUM_PRICE = 1000;

    @DisplayName("생성자 테스트")
    @Test
    void userConstructorTest() {
        // given
        int price = 12000;
        User user = new User(price);

        // when
        long buyingPriceResult = user.getUserLottoBuyingPrice();
        long userLottoQuantity = user.getUserLottoQuantity();

        // then
        assertThat(buyingPriceResult).isEqualTo(price);
        assertThat(userLottoQuantity).isEqualTo(price / LOTTO_MINIMUM_PRICE);

    }

    @DisplayName("setUserLottoNumbers 테스트")
    @Test
    void setUserLottoNumbersTest() {
        // given
        User user = new User(1000);
        int quantity = 1;
        List<UserSingleLottoNumber> singleLottoNumber = List.of(new UserSingleLottoNumber(List.of(1, 2, 3, 4, 5, 6)));

        // when
        user.setUserLottoNumbers(singleLottoNumber);

        // then
        assertThat(user.getUserLottoNumbers().size()).isEqualTo(quantity);
    }


    @DisplayName("createLottoNumbers 테스트")
    @Test
    void createLottoNumbersTest() {
        // given
        int quantity = 100;
        User user = new User(100000);
        // when
        user.createLottoNumbers(quantity);
        // then
        assertThat(user.getUserLottoNumbers().size()).isEqualTo(quantity);
    }

    @DisplayName("addUserWinningPrice 메서드 테스트")
    @Test
    void addUserWinningPriceTest() {
        // given
        User user = new User(1000);
        int winningPrice = 10000;

        // when
        user.addUserWinningPrice(winningPrice);

        // then
        assertThat(user.getUserWinningPrice()).isEqualTo(winningPrice);
    }

    @DisplayName("setUserYield 메서드 테스트")
    @Test
    void setUserYieldTest() {
        // given
        int yield = 10000;
        User user = new User(1000);

        // when
        user.setUserYield(yield);

        // then
        assertThat(user.getUserYield()).isEqualTo(yield);
    }
}
