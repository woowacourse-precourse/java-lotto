package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class UserTest {

    private static final String inputMoney = "80000";
    private static final String inputNumber = "11,22,33,44,55,66";
    private static final String inputBonusNumber = "77";
    private static final List<Integer> lotto = List.of(10, 11, 12, 13, 14, 15);

    private static final int validInputMoney = 80000;
    private static final List<Integer> validInputNumber = List.of(11, 22, 33, 44, 55, 66);
    private static final int validInputBonusNumber = 77;
    private static final int validLottoAmount = 80;
    private static final List<List<Integer>> validLotteries = List.of(
            List.of(10, 11, 12, 13, 14, 15));
    private User user;

    @BeforeEach
    void init() {
        this.user = new User();
    }

    @DisplayName("사용자의 입력 값이 잘 들어가있는지 테스트")
    @Test
    void validateUserInput() {
        User.setUserInputMoney(inputMoney);
        User.setUserInputNumber(inputNumber);
        User.setUserInputBonusNumber(inputBonusNumber);

        int money = User.getUserInputMoney();
        int bonusNumber = user.getUserInputBonusNumber();
        List<Integer> number = user.getUserInputNumber();

        assertAll(
                () -> assertThat(money).isEqualTo(validInputMoney),
                () -> assertThat(number).isEqualTo(validInputNumber),
                () -> assertThat(bonusNumber).isEqualTo(validInputBonusNumber)
        );
    }

    @DisplayName("구입금액에 따른 로또 수량이 일치하는지 테스트")
    @Test
    void checkLottoAmount() {
        User.setUserInputMoney(inputMoney);
        User.setLottoAmount();
        int lottoAmount = user.getLottoAmount();

        assertAll(
                () -> assertThat(lottoAmount).isEqualTo(validLottoAmount)
        );
    }

    @DisplayName("발행된 로또가 저장되는지 테스트")
    @Test
    void checkLottoSave() {
        User.setLotteries(lotto);
        List<List<Integer>> lotteries = user.getLotteries();
        assertAll(
                () -> assertThat(lotteries).isEqualTo(validLotteries)
        );
    }
}
