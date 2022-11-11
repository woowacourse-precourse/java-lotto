package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    @DisplayName("당첨 번호를 입력할 수 있다.")
    void test1() {
        // given
        setInput("1,2,3,4,5,6");
        Winning winning = new Winning();

        // when
        winning.inputNumber();

        // then
        List<Integer> result = winning.getNumbers();
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}