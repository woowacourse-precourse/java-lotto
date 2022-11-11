package lotto.Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputValidTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void CreateUserPriceBy1000Unit(){
        assertThat(InputValid.checkPriceUnit("1400"))
                .isEqualTo(false);

        assertThat(InputValid.checkPriceUnit("400"))
                .isEqualTo(false);
    }

    @DisplayName("구입 금액이 숫자만 있는게 아니라면 예외가 발생한다")
    @Test
    void CreateUserPriceByNumber(){
        assertThat(InputValid.checkPriceUnit("1000j"))
                .isEqualTo(false);

        assertThat(InputValid.checkPriceUnit("non"))
                .isEqualTo(false);
    }
}