package lotto.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {


    @Test
    public void randomNumberGeneratorSizeTest() throws Exception {
        assertThat(RandomNumberGenerator.generate().size()).isEqualTo(6);
    }

}
