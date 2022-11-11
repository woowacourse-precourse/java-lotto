package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMakerTest {

    LottoMaker lottoMaker = new LottoMaker();

    @DisplayName("랜덤 로또 리스트가 잘 생성되는지 확인")
    @Test
    void 여러개의_랜덤_로또_출력_확인() {
        List<Lotto> lottos = lottoMaker.getRandomLottos(5);
        assertThat(lottos)
                .hasSize(5)
                .allMatch((lotto) -> lotto instanceof Lotto);
    }
}
