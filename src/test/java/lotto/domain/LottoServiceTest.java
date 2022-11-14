package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    @DisplayName("로또 티켓이 입력한 금액만큼 생성됐는지 확인한다.")
    @Test
    void generate() {
        List<Lotto> tickets = LottoService.generate(6000);
        assertThat(tickets.size()).isEqualTo(6);
    }
}