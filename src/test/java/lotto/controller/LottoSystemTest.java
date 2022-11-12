package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoSystemTest {

    LottoSystem lottoSystem = new LottoSystem();

    @Test
    public void createLottoQuantity() {
        //given
        int userMoney = 5000;
        //when
        int quantity = lottoSystem.LottoQuantityCalculation(userMoney);
        //then
        assertThat(quantity).isEqualTo(5);
    }

}