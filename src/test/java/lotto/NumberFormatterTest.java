package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberFormatterTest {

    @Test
    void int_1001_변환_정상() {
        Assertions.assertThat(NumberFormatter.format(1001)).isEqualTo("1,001");
    }

    @Test
    void int_64_변환_정상() {
        Assertions.assertThat(NumberFormatter.format(64)).isEqualTo("64");
    }

    @Test
    void int_123456789_변환_정상() {
        Assertions.assertThat(NumberFormatter.format(123456789)).isEqualTo("123,456,789");
    }

    @Test
    void double_100_12_변환() {
        Assertions.assertThat(NumberFormatter.format(100.12)).isEqualTo("100.1");
    }

    @Test
    void double_123456789_12_변환() {
        Assertions.assertThat(NumberFormatter.format(123456789.15)).isEqualTo("123,456,789.2");
    }

    @Test
    void double_726_0_변환() {
        Assertions.assertThat(NumberFormatter.format(726.0)).isEqualTo("726");
    }
}