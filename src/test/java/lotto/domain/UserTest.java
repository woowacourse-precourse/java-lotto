package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private User user;

    void setUp(int input) {
        user = new User();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);
    }

    @DisplayName("유저의 돈이 정상적으로 입력된다.")
    @Test
    void createMoney() {
        int input = 18000;
        setUp(input);

        assertThat(user.getMoneyInput()).isEqualTo(input);
    }

    @DisplayName("유저의 돈 입력이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void createMoneyByWrongUnit() {
        int input = 1800;
        setUp(input);

        Throwable exception = assertThrows(IllegalArgumentException.class, user::getMoneyInput);
        assertEquals("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.", exception.getMessage());
    }
}
