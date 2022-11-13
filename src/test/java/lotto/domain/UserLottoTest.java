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
    void purchaseLottoByUnit() {
       UserLotto userLotto = new UserLotto();
       int input = 5100;
       assertThatThrownBy(() -> userLotto.validateUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}