package lotto.generation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void 로또_생성_개수_확인() {
        assertThat(new LottoGenerator().generateLottos(13000).size()).isEqualTo(13);
    }
}
