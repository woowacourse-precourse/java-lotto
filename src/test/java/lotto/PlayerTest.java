package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Player player = new Player();

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

    @Test
    void getLottoNumbers() {
    }

    @Test
    void checkGetLottoNumbers() {
    }

    @Test
    void makeGenerate() {
    }

    @Test
    void calculateResult() {
    }

    @Test
    void showResult() {
    }
}