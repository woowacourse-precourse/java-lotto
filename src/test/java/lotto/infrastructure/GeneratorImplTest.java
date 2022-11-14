package lotto.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneratorImplTest {

    private Generator generator;

    @BeforeEach
    void setUp() {
        generator = new GeneratorImpl();
    }

    @Test
    public void numbersSeparatorValueTest() throws Exception {
        String str = "1,2";
        assertThat(generator.numberSeparator(str)).containsExactly("1", "2");
    }


}
