package lotto.Utils;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void CreateUserPriceBy1000Unit(){
        assertThatThrownBy(()->InputValid.checkPriceUnit(1400))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputValid.checkPriceUnit(400))
                .isInstanceOf(IllegalArgumentException.class);
    }
}