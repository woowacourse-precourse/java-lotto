package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    @ParameterizedTest
    @CsvSource(value = {"1234: 1,234", "1000000: 1,000,000", "2100000000: 2,100,000,000"}, delimiter = ':')
    void 세자리마다_컴마를_잘_찍는지_테스트(float target, String expected) {
        DecimalFormat formatter = new DecimalFormat("###,###.#");
        assertThat(formatter.format(target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0.1234: 0.1234", "0.12345678: 0.12345678"}, delimiter = ':')
    void 소숫점은_컴마를_안_찍는지_테스트(float target, String expected) {
        DecimalFormat formatter = new DecimalFormat("###,###.########");
        assertThat(formatter.format(target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0.0: 0.0", "123.0: 123.0", "3423.0: 3,423.0"}, delimiter = ':')
    void 소숫점이_없어도_소수점을_0으로_나타내는지_테스트(float target, String expected) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        assertThat(formatter.format(target)).isEqualTo(expected);
    }
}
