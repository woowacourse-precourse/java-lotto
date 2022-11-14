package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class UserTest {

    private static final String INPUT_MONEY = "80000";
    private static final String INPUT_NUMBER = "11,22,33,44,55,66";
    private static final String INPUT_BONUS_NUMBER = "77";
    private static final List<Integer> LOTTO = List.of(10, 11, 12, 13, 14, 15);

    private static final int VALID_INPUT_MONEY = 80000;
    private static final List<Integer> VALID_INPUT_NUMBER = List.of(11, 22, 33, 44, 55, 66);
    private static final int VALID_INPUT_BONUS_NUMBER = 77;
    private static final int VALID_LOTTO_AMOUNT = 80;
    private static final List<List<Integer>> VALID_LOTTERIES = List.of(
            List.of(10, 11, 12, 13, 14, 15));
    private User user;

    @BeforeEach
    void init() {
        this.user = new User();
    }

    @DisplayName("사용자의 입력 값이 잘 들어가있는지 테스트")
    @Test
    void validateUserInput() {
        User.setUserInputMoney(INPUT_MONEY);
        User.setUserInputNumber(INPUT_NUMBER);
        User.setUserInputBonusNumber(INPUT_BONUS_NUMBER);

        int money = User.getUserInputMoney();
        int bonusNumber = user.getUserInputBonusNumber();
        List<Integer> number = user.getUserInputNumber();

        assertAll(
                () -> assertThat(money).isEqualTo(VALID_INPUT_MONEY),
                () -> assertThat(number).isEqualTo(VALID_INPUT_NUMBER),
                () -> assertThat(bonusNumber).isEqualTo(VALID_INPUT_BONUS_NUMBER)
        );
    }

    @DisplayName("구입금액에 따른 로또 수량이 일치하는지 테스트")
    @Test
    void checkLottoAmount() {
        User.setUserInputMoney(INPUT_MONEY);
        User.setLottoAmount();
        int lottoAmount = user.getLottoAmount();

        assertAll(
                () -> assertThat(lottoAmount).isEqualTo(VALID_LOTTO_AMOUNT)
        );
    }

    @DisplayName("발행된 로또가 저장되는지 테스트")
    @Test
    void checkLottoSave() {
        User.setLotteries(LOTTO);
        List<List<Integer>> lotteries = user.getLotteries();
        assertAll(
                () -> assertThat(lotteries).isEqualTo(VALID_LOTTERIES)
        );
    }
}
