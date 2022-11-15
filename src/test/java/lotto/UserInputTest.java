package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {

    @DisplayName("입력 금액이 1,000으로 나눠떨어져야 한다.")
    @Test
    void isValidPurchaseAmount() {
        // given
        String userInput = "2000";
        int expectAmount = 2;

        // when
        int result = new User().lottoPurchaseAmount(userInput);

        // then
        assertThat(result).isEqualTo(expectAmount);
    }

    @DisplayName("입력 금액이 1,000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void IsNotValidPurchaseAmount() {
        // given
        String userInput = "2100";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User().lottoPurchaseAmount(userInput);
        });
    }

    @DisplayName("사용자 로또 번호는 쉼표로 구분된 여섯 자리의 숫자여야 한다.")
    @Test
    void isUserValidLottoNumbers() {
        // given
        String userInput = "34,12,43,32,3,22";
        int expectSize = 6;

        // when
        Lotto result = new Lotto(userInput);

        // then
        assertThat(result.getNumbers().size()).isEqualTo(expectSize);
    }

    @DisplayName("사용자 로또 번호는 여섯 자리의 숫자보다 적으면 예외가 발생한다.")
    @Test
    void isShorterThanSix() {
        // given
        String userInput = "34,12,43,32,3";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(userInput);
        });
    }

    @DisplayName("사용자 로또 번호는 여섯 자리의 숫자보다 길면 예외가 발생한다.")
    @Test
    void isLongerThanSix() {
        // given
        String userInput = "34,12,43,32,3,5,1";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new  Lotto(userInput);
        });
    }

    @DisplayName("사용자 로또 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void isDuplicatedLottoNumbers() {
        // given
        String userInput = "2,2,43,32,3,22";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new  Lotto(userInput);
        });
    }

    @DisplayName("사용자 로또 번호에 숫자와 ,외에 다른 것이 오면 예외가 발생한다.")
    @Test
    void isNotNumberAndCommaLottoNumbers() {
        // given
        String userInput = "1,2,43,32,3,r";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new  Lotto(userInput);
        });
    }

    @DisplayName("보너스 번호는 1~45 숫자 하나이다.")
    @Test
    void isBonusValidLottoNumbers() {
        // given, when, then
        String userInput = "7";
        new User().isNumberAndInRange(userInput);
    }

    @DisplayName("보너스 번호는 1~45 숫자 범위가 아니면 예외를 발생한다.")
    @Test
    void isNotBonusValidLottoNumbers() {
        // given
        String userInput = "46";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User().isNumberAndInRange(userInput);
        });
    }

    @DisplayName("보너스 번호에 문자가 있으면 예외를 발생한다.")
    @Test
    void isCharContainBonusLottoNumbers() {
        // given
        String userInput = "2a";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User().isNumberAndInRange(userInput);
        });
    }

    @DisplayName("보너스 번호와 로또 번호가 중복되면 예외가 발생한다.")
    @Test
    void isLottoContainBonus() {
        // given
        String lotto = "34,12,43,32,3,22";
        String bonus = "34";
        User user = new User();
        user.setUserNumbers(new Lotto(lotto));

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.isValidBonusNumber(bonus);
        });
    }
}
