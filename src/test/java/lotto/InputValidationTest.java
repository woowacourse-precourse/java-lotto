package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {


    @Test
    @DisplayName("구매 금액에 숫자가 아닌 입력")
    public void NotNumber() throws Exception{
        Assertions.assertThatThrownBy( ()->
                InputValidation.numberFormatExceptionValidation("안녕하세요"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}