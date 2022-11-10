package exception;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.exception.Valid;
import util.message.ErrorMessage;

class ValidTest {

    @Test
    @DisplayName("[Valid-isDigit]Input이 숫자가 아님을 유효성 테스트")
    public void isNotDigit() {
        //given
        String notDigit = "193in23put";
        //when
        boolean result = Valid.isDigit(notDigit);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("[Valid-isDigit]Input이 숫자가 맞음을 유효성 테스트")
    public void isDigit() {
        //given
        String digit = "1932";
        //when
        boolean result = Valid.isDigit(digit);
        //then
        assertThat(result).isTrue();
    }


}