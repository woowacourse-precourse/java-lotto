package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    @DisplayName("로또번호가 구매내역만큼 생성되었는지 확인")
    @Test
    void createQuotientByMoney() {
        LottoGenerator lottos = new LottoGenerator(4);
        assertThat(lottos.getLottoList().size()).isEqualTo(4);
    }
}