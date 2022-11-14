package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private User user;

    void setUp(String input) {
        user = new User();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("유저의 돈이 정상적으로 입력된다.")
    @Test
    void createMoney() {
        String input = "18000";
        setUp(input);

        assertThat(user.getMoneyInput()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("유저의 돈 입력이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void createMoneyByWrongUnit() {
        String input = "1800";
        setUp(input);

        Throwable exception = assertThrows(IllegalArgumentException.class, user::getMoneyInput);
        assertEquals("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.", exception.getMessage());
    }

    @DisplayName("유저의 돈이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createMoneyByWrongType() {
        String input = "abcd";
        setUp(input);

        assertThatThrownBy(() -> user.getMoneyInput())
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("유저의 로또 번호가 정상적으로 입력된다.")
    @Test
    void createLotto() {
        String input = "1,2,3,4,5,6";
        setUp(input);

        List<Integer> lotto = Arrays.stream(Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        assertThat(user.getLottoInput()).isEqualTo(lotto);
    }

    @DisplayName("유저의 로또 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByWrongType() {
        String input = "1,ㅊ,3,b,5,6";
        setUp(input);

        assertThatThrownBy(() -> user.getLottoInput())
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("유저의 로또 번호가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByWrongSize() {
        String input = "1,2,3";
        setUp(input);

        Throwable exception = assertThrows(IllegalArgumentException.class, user::getLottoInput);
        assertEquals("[ERROR] 숫자 6개를 입력해주세요.", exception.getMessage());
    }
}
