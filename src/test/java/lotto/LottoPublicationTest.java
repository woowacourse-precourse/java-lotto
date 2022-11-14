package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoPublication;
import lotto.domain.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublicationTest {

    @DisplayName("주어진 숫자만큼 로또 발행")
    @Test
    void publicationLottoByCount(){
        Lottos lottos = LottoPublication.publicationLottos(8);
        assertThat(lottos.getLotts().size()).isEqualTo(8);
    }
}
