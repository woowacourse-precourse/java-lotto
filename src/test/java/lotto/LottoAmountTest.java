package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAmountTest {
    LottoAmount lottoAmount;

    @BeforeEach
    void setUp(){
        lottoAmount = new LottoAmount();
    }

    @DisplayName("금액이 개수로 잘 환산되는지 확인")
    @Test
    void caculInputMoney(){
        //given
        int money = 3000;

        //when
        int actual = lottoAmount.caculInputMoney(money);

        //then
        assertThat(actual).isEqualTo(3);
    }
}
