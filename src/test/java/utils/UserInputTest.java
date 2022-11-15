package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void 구입금액이_숫자인지_유효성검사_테스트(){
        String input = "abc";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.inputMoney();
        });
        assertEquals("[ERROR] 숫자 혹은 형식에 맞게 입력해주세요.", exception.getMessage());
    }

    @Test
    void 구입금액이_1000단위인지_유효성검사_테스트(){
        String input = "1500";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.inputMoney();
        });
        assertEquals("[ERROR] 1,000원 단위로만 입력해주세요.", exception.getMessage());
    }

    @Test
    void 당첨번호_입력_형식이_올바른지_유효성검사_테스트(){
        String input = "1 2 3 4 5 6";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.inputLottoNumber();
        });
        assertEquals("[ERROR] 형식에 맞게 입력해주세요. 번호는 쉼표(,)를 기준으로 구분합니다.", exception.getMessage());
    }

    @Test
    void 입력되는_보너스번호가_1부터_45까지_수인지_유효성검사_테스트(){
        String input = "47";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.inputBonusNumber();
        });
        assertEquals("[ERROR] 1부터 45까지의 숫자만 입력해주세요.", exception.getMessage());
    }

}