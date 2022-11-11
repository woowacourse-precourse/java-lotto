package lotto.UI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }


    @DisplayName("구매금액 입력시 문자,공백을 입력하면 예외가 발생한다")
    @Test
    void 문자_공백_검사() {
        String input = "천원";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.askPurchaseAmount());
        assertEquals("[ERROR] 문자 또는 공백은 입력이 불가능 합니다. 1,000원 단위의 숫자를 입력해 주세요.", illegalArgumentException.getMessage());
    }


    @DisplayName("구매금액 입력시 1,000원 단위가 아니라면 예외가 발생한다")
    @Test
    void 천원_단위_검사() {

        Integer monetaryUnitTest1 = 1000;
        Integer monetaryUnitTest2 = 1500;

        // return true;
        assertTrue(user.checkMonetaryUnit(monetaryUnitTest1));

        // throw new IllegalArgumentException(" [ERROR] 1,000원 단위의 숫자를 입력 해주세요. ")
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.checkMonetaryUnit(monetaryUnitTest2));
        assertEquals("[ERROR] 1,000원 단위의 숫자를 입력해 주세요.", illegalArgumentException.getMessage());

    }
}