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
        assertEquals("[ERROR] 숫자만 입력해주세요.", exception.getMessage());
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

}