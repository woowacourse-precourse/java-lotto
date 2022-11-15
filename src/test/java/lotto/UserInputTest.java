package lotto;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {
    private UserInput userInput = new UserInput();
    void setUp(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("유저의 돈이 입력된다.")
    @Test
    void createMoney() {
        String input = "18000";
        setUp(input);

        assertThat(userInput.getMoneyInput()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("유저의 로또 번호가 입력된다.")
    @Test
    void createLotto() {
        String input = "1,2,3,4,5,6";
        setUp(input);
        List<Integer> lotto = Arrays.stream(Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        assertThat(userInput.getLottoInput()).isEqualTo(lotto);
    }

    @DisplayName("유저의 보너스 번호가 입력된다.")
    @Test
    void createBonus() {
        String input = "7";
        setUp(input);
        assertThat(userInput.getBonusInput()).isEqualTo(Integer.parseInt(input));
    }
}
