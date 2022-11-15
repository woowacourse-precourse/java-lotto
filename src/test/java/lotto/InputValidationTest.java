package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {


    @Test
    @DisplayName("구매 금액에 숫자가 아닌 입력")
    public void NotNumber() throws Exception{
        Assertions.assertThatThrownBy( ()->
                InputValidation.numberFormatExceptionValidation("안녕하세요"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName(",로 입력이 들어오지 않을 때")
    public void NotComma() throws Exception{
        Assertions.assertThatThrownBy(()->
                InputValidation.winningNumberValidation("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함된 번호일 때 ")
    public void bonusEqWinningNumber() throws Exception{
        Assertions.assertThatThrownBy(()->
                        InputValidation.bonusNumberValidation("1",new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    
    }
}