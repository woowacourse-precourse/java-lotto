package lotto.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void 입력_테스트() {
        Input input = new Input(10000, Arrays.asList(1, 3, 5, 7, 8, 15), 20);
        Assertions.assertThat(input.getBonusNumber()).isEqualTo(20);
    }

}