package lotto;

import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @DisplayName("유저가 돈을 투입할 때 예외 테스트")
    @ParameterizedTest
    @CsvSource({"1000,true","1001,false"})
    void userPayMoneyTest(String input, boolean expectedException) throws Exception {
        User user = new User();

        if (expectedException) {
            assertThatCode(() -> user.payMoney(Integer.parseInt(input)))
                    .doesNotThrowAnyException();
        }
        if (!expectedException) {
            assertThatThrownBy(() -> user.payMoney(Integer.parseInt(input)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("유저 돈 투입 시 발생하는 게임 횟수 값 테스트")
    @ParameterizedTest
    @CsvSource({"1000,1","2000,2","18000,18"})
    void userBuyLottoTest(String input, int lottoCount) {
        User user = new User();
        user.payMoney(Integer.parseInt(input));
        user.buyLotto();

        assertThat(user.getLottoCount()).isEqualTo(lottoCount);
    }
}