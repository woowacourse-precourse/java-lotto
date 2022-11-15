package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @DisplayName("당첨 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void createComputerWithNotNaturalNumber() {
        String input = "1,2,3,4,5,a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
