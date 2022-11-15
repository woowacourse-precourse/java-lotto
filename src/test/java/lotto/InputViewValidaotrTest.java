package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewValidaotrTest {
    InputValidator inputValidator;
    String moneyinput;

    @BeforeEach
    void setUp(){
        moneyinput = "8000원";
        inputValidator = new InputValidator(moneyinput);
    }


    @DisplayName("입력값에 문자가 있으면 오류 발생")
    @Test
    void checkOnlyNumber(){
        //given

        //when
        assertThatThrownBy(() -> inputValidator.checkOnlyNumber(moneyinput))
                .isInstanceOf(IllegalArgumentException.class);


    }
}
