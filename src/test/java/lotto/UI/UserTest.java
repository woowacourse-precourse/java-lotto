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

        // throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자를 입력 해주세요.")
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.checkMonetaryUnit(monetaryUnitTest2));
        assertEquals("[ERROR] 1,000원 단위의 숫자를 입력해 주세요.", illegalArgumentException.getMessage());

    }

    @DisplayName("문자공백 입력시 예외가 발생한다")
    @Test
    void 로또_문자_공백_검사() {
        String input = "일,이,삼,사,오,육";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.lottoNumberReceiveInput());
        assertEquals("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 숫자 6개를 입력해 주세요.", illegalArgumentException.getMessage());
    }

    @DisplayName("보너스 번호 입력시 문자,공백 입력시 예외가 발생한다")
    @Test
    void 보너스_번호_문자_공백_검사() {
        String input = "삼";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.inputBonusNumber());
        assertEquals("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 숫자 한개를 입력해 주세요.", illegalArgumentException.getMessage());

    }

    @DisplayName("보너스 번호의 범위 1~45가 아닐시 예외가 발생한다")
    @Test
    void 보너스_번호_범위_검사() {
        Integer TestTrue = 11;
        Integer TestFalse = 77;
        // TestTrue
        assertEquals(11, user.bonusNumberRangeCheck(TestTrue));
        // throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자 한개를 입력해 주세요.")
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                user.bonusNumberRangeCheck(TestFalse));
        assertEquals("[ERROR] 1~45 사이의 숫자 한개를 입력해 주세요.", illegalArgumentException.getMessage());

    }

}