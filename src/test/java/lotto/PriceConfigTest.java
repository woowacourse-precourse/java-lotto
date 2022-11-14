package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceConfigTest {
    @Test
    void getLottoCountWithoutChange () {
        assertThat(PriceConfig.getLottoCountWithoutChange(8000)).isEqualTo(8);
        assertThat(PriceConfig.getLottoCountWithoutChange(8020)).isEqualTo(8);
    }
}
