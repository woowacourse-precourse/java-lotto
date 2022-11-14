package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void ShouldBe2DecimalPointAndComma() {
        // given
        double yieldRaw = Math.round(7777 * 10 / 3) / 10.0;
        // when
        DecimalFormat decFormat = new DecimalFormat("###,###.##");
        String yield = decFormat.format(yieldRaw);
        // then
        assertThat(yield).isEqualTo("2,592.3");
    }
}
