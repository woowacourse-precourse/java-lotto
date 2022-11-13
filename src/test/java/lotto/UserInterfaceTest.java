package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    public static final UserInterface userInterface = new UserInterface();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("숫자 이외의 구입 금액 입력 시 에러 발생")
    @Test
    void 구입_금액_문자_포함시_에러_발생() {
        System.setIn(generateUserInput("-8000v"));
        assertThatThrownBy(userInterface::inputPaidMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 있는 구입 금액 입력")
    @Test
    void 구입_금액_숫자만_테스트() {
        System.setIn(generateUserInput("123456789"));
        int money = userInterface.inputPaidMoney();
        assertThat(money).isEqualTo(123456789);
    }
}