package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class LottoControllerTest {
    LottoController lottoController;

    @BeforeEach
    void beforeEach(){
        lottoController = new LottoController();
    }

    @Nested
    class priceCheck {
        @Test
        public void priceStringException() throws Exception {
            //given
            String price = "asd";
            //when
            //then
            assertThatThrownBy(() -> lottoController.doValidatePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void priceIntException() throws Exception{
            //given
            String price = "6001";
            //when
            //then
            assertThatThrownBy(() -> lottoController.doValidatePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void priceTest() throws Exception{
            //given
            String price = "6000";
            //when
            int retPrice = lottoController.doValidatePrice(price);
            //then
            Assertions.assertThat(retPrice).isEqualTo(Integer.parseInt(price));
        }
    }
}