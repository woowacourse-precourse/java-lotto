package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void 구매금액입력받기(){
        User user = new User();

        String notEffectiveUnit = "3500";
        String notDisit = "3d500";
        String good = "3000";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> user.inputPurchaseAmount(notEffectiveUnit));
        assertThat(exception.getMessage()).isEqualTo(LottoException.NOT_EFFECTIVE_UNIT.getErrorMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()-> user.inputPurchaseAmount(notDisit));
        assertThat(exception1.getMessage()).isEqualTo(LottoException.NOT_DISIT.getErrorMessage());

        user.inputPurchaseAmount(good);
        assertThat(Integer.parseInt(good)).isEqualTo(user.getPurchaseAmount());
    }
}