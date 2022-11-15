package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPublisherTest {
    private LottoPublisher lottoPublisher;

    @BeforeEach
    void setUp() {
        lottoPublisher = LottoPublisher.getInstance();
    }

    @ParameterizedTest
    @CsvSource({"3000, 3", "1000, 1", "20000, 20"})
    void 정상적인_구입금액_로또개수(int money, int lottoCnt) {
        List<Lotto> lottos = lottoPublisher.publish(money);
        assertThat(lottos.size()).isEqualTo(lottoCnt);
    }
}