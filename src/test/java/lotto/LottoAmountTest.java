package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {
    @Test
    void LottoAmount_success_test(){
        LottoAmount lottoAmount = new LottoAmount(3000);
        assertThat(lottoAmount.getAmount()).isEqualTo(3);
    }

    @Test
    void LottoAmount_fail_test(){
        Assertions.assertThatThrownBy(() -> new LottoAmount(123),"fail_test" ,IllegalArgumentException.class);
    }

}