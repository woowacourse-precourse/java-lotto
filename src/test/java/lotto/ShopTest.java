package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShopTest {

    @DisplayName("숫자가 아닌 입력에 대해 에러가 발생하는지")
    @Test
    void notNumberException() {
        String userInput = "1200j";

        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            Application.main(new String[]{});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("1000원 단위가 아닌 입력에 대해 에러가 발생하는지")
    @Test
    void notDividedThousand() {
        String userInput = "12300";

        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            Application.main(new String[]{});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구매한 로또 출력")
    @Test
    void printLotteryTickets() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));

        System.setIn(new ByteArrayInputStream("4000".getBytes()));
        Application.main(new String[]{});

        assertThat(stdOut.toString()).contains("4개");
    }
}