package lotto;

import lotto.UI.View;
import lotto.domain.Game;
import lotto.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ControllerTest {

    Controller controller;
    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    @DisplayName("아래 테스트들은 모두 domain 패키지 클래스의 예외 처리까지 포함한다.")
    @Test
    void beforeEach() {
        controller = new Controller(new Game(), new User(), new View());
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("정수가 아닌 구매 금액을 입력했을 시 예외가 발생한다.")
    @Test
    public void setBudget() {
        String input = "예외 발생";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> controller.setBudget()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력을 split 했을 때 정수가 아닌 것이 포함되어 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbers() {
        String input = "1, 2, 3, 4, 5, 나는예외지롱";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> controller.setWinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void setBonus() {
        String input = "예외 발생";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> controller.setBudget()).isInstanceOf(IllegalArgumentException.class);
    }

}