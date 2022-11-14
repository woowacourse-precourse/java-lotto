package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Player player;
    @BeforeEach
    void initiatePlayerTest() {
         player = new Player();
    }
    @DisplayName("로또 구입 금액으로 8000원을 입력하면 8장이 반환된다.")
    @Test
    void purchaseLotto() {
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = player.purchaseLotto();
        int expect = 8;
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("로또 구입 금액으로 1234원을 입력하면 예외가 발생한트")
    @Test
    void purchaseLottoException() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.purchaseLotto();
        });
    }
}