package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FeatureTest {
    Input input;

    @Test
    void 입력을_숫자로_변환() {
        String input = "1400";
        assertThat(Input.getInputToInt(input)).isEqualTo(1400);
    }
}
