package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    public static final UserInterface userInterface = new UserInterface();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("숫자 이외의 문자 입력 시 에러 발생")
    @Test
    void 숫자_이외의_문자_포함시_에러_발생() {
        System.setIn(generateUserInput("-8000v"));
        assertThatThrownBy(userInterface::inputOnlyNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 있는 입력")
    @Test
    void 숫자만_입력() {
        System.setIn(generateUserInput("123456789"));
        int money = userInterface.inputOnlyNumber();
        assertThat(money).isEqualTo(123456789);
    }

    @DisplayName("형식에 맞지 않는 당첨 번호 입력시 에러 발생")
    @Test
    void 형식에_맞지_않는_당첨_번호_에러_발생() {
        System.setIn(generateUserInput("1,2,,3,4,5,6"));
        assertThatThrownBy(userInterface::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(generateUserInput("1-2-3 4-5-6"));
        assertThatThrownBy(userInterface::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞는 당첨 번호 입력")
    @Test
    void 형식에_맞는_당첨_번호() {
        System.setIn(generateUserInput("1,2,3,4,5,6"));
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winning = userInterface.inputWinningNumbers();
        assertThat(winning).isEqualTo(answer);
    }
}