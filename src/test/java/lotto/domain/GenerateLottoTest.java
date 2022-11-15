package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class GenerateLottoTest {

    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = new GenerateLotto().buyLotto(15000);
        assertThat(lottos.size()).isEqualTo(15);
    }
}