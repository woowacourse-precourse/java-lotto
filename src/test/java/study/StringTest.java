package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void ShouldBe2DecimalPointAndComma() {
        // given
        double yieldRaw = 16283 / 3.0;
        // when
        DecimalFormat decFormat = new DecimalFormat("###,###.0");
        String yield = decFormat.format(yieldRaw);
        // then
        assertThat(yield).isEqualTo("5,427.7");
    }

    @Test
    void ShouldBeIntegerWhenParse() {
        // given
        String numberRaw = "01";
        // when
        int number = Integer.parseInt(numberRaw);
        // then
        assertThat(number).isEqualTo(1);
    }
}
