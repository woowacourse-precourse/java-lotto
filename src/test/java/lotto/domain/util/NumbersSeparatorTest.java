package lotto.domain.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersSeparatorTest {
    @Test
    public void numbersSeparatorValueTest() throws Exception {
        String str = "1,2";
        Assertions.assertThat(NumbersSeparator.generate(str)).containsExactly("1", "2");
    }
}
