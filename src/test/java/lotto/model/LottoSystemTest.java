package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSystemTest {

    @DisplayName("수량 만큼 로또 생성 및 추가")
    @Test
    void add_lotto() {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.addLotto(5);
        assertThat(lottoSystem.getLottoQuantity()).isEqualTo(5);
    }


}
