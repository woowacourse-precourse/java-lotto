package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    final private String ERROR = "[ERROR]";

    @Test
    void 돈_입력_예외_1() {
        UserInput user = new UserInput();
        String input = "1100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> user.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_예외_2() {
        UserInput user = new UserInput();
        String input = "NotaNumber";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> user.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_테스트() {
        UserInput user = new UserInput();
        String input = "2000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long a = user.inputMoney();
        assertThat(a).isEqualTo(2000);
    }

    @Test
    void 로또_구매_생성() {
        UserInput user = new UserInput();
        user.generateRandomLotto(3);
        int lottoSize = 3;
        assertThat(user.lotteries.size()).isEqualTo(lottoSize);
    }

    @Test
    void 로또_구매_생성_2() {
        UserInput user = new UserInput();
        user.generateRandomLotto(1);
        int lottoSize = 6;
        assertThat(user.lotteries.get(0).size()).isEqualTo(lottoSize);
    }

    @Test
    void 당첨_번호_입력_예외_1() {
        UserInput user = new UserInput();
        String input = "나, 5, 6, 7, 가";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_메시지() {
        UserInput user = new UserInput();
        String input = "1000j";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> user.inputMoney())
                .hasMessageContaining("[ERROR]")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
