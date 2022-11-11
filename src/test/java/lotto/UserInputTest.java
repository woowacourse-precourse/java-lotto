package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    final private String ERROR = "[ERROR]";

    @AfterEach
    void 구매_로또_초기화() {
        UserInput.lotteries.clear();
    }
    @Test
    void 돈_입력_예외_1() {
        String input = "1100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> UserInput.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_예외_2() {
        String input = "NotaNumber";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> UserInput.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_테스트() {
        String input = "2000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long a = UserInput.inputMoney();
        assertThat(a).isEqualTo(2000);
    }

    @Test
    void 로또_구매_생성() {
        UserInput.generateRandomLotto(3);
        int lottoSize = 3;
        assertThat(UserInput.lotteries.size()).isEqualTo(lottoSize);
    }

    @Test
    void 로또_구매_생성_2() {
        UserInput.generateRandomLotto(1);
        int lottoSize = 6;
        assertThat(UserInput.lotteries.get(0).size()).isEqualTo(lottoSize);
    }

    @Test
    void 당첨_번호_입력_예외_1() {
        String input = "나, 5, 6, 7, 가";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> UserInput.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_메시지() {
        String input = "1000j";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> UserInput.inputMoney())
                .hasMessageContaining("[ERROR]")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
