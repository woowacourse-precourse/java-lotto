package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputCheckerTest{
    InputChecker inputChecker;

    @BeforeEach
    void setup(){
        inputChecker=new InputChecker();
    }

    @DisplayName("입력한 숫자가 정수가 아닌 경우 예외 발생 확인")
    @Test
    void isDigitTest(){
        assertThatThrownBy(()->inputChecker.isDigit("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}