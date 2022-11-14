package lotto.service;

import lotto.controller.LottoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void beforeEach(){
        lottoService = new LottoService();
    }

    @Nested
    class PriceCheck {
        @Test
        public void priceStringException() throws Exception {
            //given
            String price = "asd";
            //when
            //then
            assertThatThrownBy(() -> lottoService.validePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void priceIntException() throws Exception{
            //given
            String price = "6001";
            //when
            //then
            assertThatThrownBy(() -> lottoService.validePrice(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void priceTest() throws Exception{
            //given
            String price = "6000";
            //when
            Integer retPrice = lottoService.validePrice(price);
            //then
            Assertions.assertThat(retPrice).isEqualTo(Integer.parseInt(price));
        }
    }
    @Nested
    class LottoNumberCheck{
        @Test
        public void inputString() throws Exception{
            //given
            String userInput = "qwpoekjqpj";
            //when
            //then
            assertThatThrownBy(() -> lottoService.validateUserInput(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void inputFiveNumber(){
            //given
            String userInput = "1,2,3,4,5";
            //when
            //then
            assertThatThrownBy(() -> lottoService.validateUserInput(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void inputWithoutComma(){
            //given
            String userInput = "1 2 3 4 5";
            //when
            //then
            assertThatThrownBy(() -> lottoService.validateUserInput(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        public void inputSuccess() throws Exception{
            //given
            String userInput = "1,2,3,4,5,6";
            //when
            lottoService.validateUserInput(userInput);
            //then
        }
    }
}
