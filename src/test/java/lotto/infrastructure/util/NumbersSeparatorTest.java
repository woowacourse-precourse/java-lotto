package lotto.infrastructure.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersSeparatorTest {

    @Test
    public void numberSeparatorTest() throws Exception {
        String str = "1,2";
        assertThat(NumbersSeparator.generate(str)).contains("1", "2");
    }

}
