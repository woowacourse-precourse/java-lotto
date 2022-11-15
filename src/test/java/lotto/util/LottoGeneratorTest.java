package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @DisplayName("6개로 이뤄진 로또 번호를 반환한다.")
    @Test
    void generateTest_숫자6개() {
        Assertions.assertThat(LottoGenerator.generate()).size().isEqualTo(6);
    }

    @DisplayName("각 숫자가 범위 내에 있는 로또 번호를 반환한다.")
    @Test
    void generateTest_범위내의숫자() {
        Assertions.assertThat(Validator.isInRange(LottoGenerator.generate())).isTrue();
    }
}
