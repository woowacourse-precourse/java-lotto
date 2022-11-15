package lotto.domain;

import lotto.Lotto;
import lotto.controller.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseAmountByUnit() {
       UserLotto userLotto = new UserLotto();
       int input = 5100;
       assertThatThrownBy(() -> userLotto.validateUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void purchaseAmountByRange() {
        UserLotto userLotto = new UserLotto();
        int input = 900;
        assertThatThrownBy(() -> userLotto.validateUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 문자가 들어가면 예외가 발생한다.")
    @Test
    void purchaseAmountByLetter() {
        UserLotto userLotto = new UserLotto();
        String input = "100a00";
        assertThatThrownBy(() -> userLotto.validateLetter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}