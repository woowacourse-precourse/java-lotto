package lotto;

import lotto.ENUMS.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외 처리")
    void numberOfLotto() {
        int input = 20001;
        User user = new User(input);

        assertThatThrownBy(() -> user.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.ERROR_SIGN.getErrorMessage()
                        + " " + ErrorMessages.DIVIDE_ERROR.getErrorMessage());
    }

    // 2. 로또를 긁어서 당첨된다면 당첨된 등수를 저장
    // 3. 구입 금액과 총 당첨금을 비교하여 수익률 정산
}