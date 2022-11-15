package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPublisherTest {
    private static final LottoMetadata lottoMetadata = new LottoMetadata.Builder().build();

    @DisplayName("개수 만큼 로또를 발행한다.")
    @Test
    void purchaseMultipleLotto() {
        LottoPublisher lottoPublisher = new LottoPublisher(lottoMetadata);

        List<Lotto> lottos = lottoPublisher.purchase(12);

        assertThat(lottos.size()).isEqualTo(12);
    }
}