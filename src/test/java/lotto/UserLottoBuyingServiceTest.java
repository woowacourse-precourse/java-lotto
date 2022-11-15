package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.NoSuchElementException;
import lotto.domian.User;
import lotto.service.UserLottoBuyingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoBuyingServiceTest {

    UserLottoBuyingService userLottoBuyingService = new UserLottoBuyingService();

    @DisplayName("checkThisBuyingPriceIsValid 메서드 테스트")
    @Test()
    void checkThisBuyingPriceIsValidTest() {
        assertThatThrownBy(() -> userLottoBuyingService.checkThisBuyingPriceIsValid(""))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userLottoBuyingService.checkThisBuyingPriceIsValid(" "))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userLottoBuyingService.checkThisBuyingPriceIsValid("money"))
          .isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> userLottoBuyingService.checkThisBuyingPriceIsValid("999"))
          .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userLottoBuyingService.checkThisBuyingPriceIsValid("12345"))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("setUserTotalLotto 메서드 테스트")
    @Test
    void setUserTotalLottoTest() {
        // given
        User user = new User(1000);
        int userLottoQuantity = 1;

        // when
        userLottoBuyingService.setUserTotalLotto(user);

        // then
        assertThat(user.getUserLottoNumbers().size()).isEqualTo(userLottoQuantity);
    }
}
