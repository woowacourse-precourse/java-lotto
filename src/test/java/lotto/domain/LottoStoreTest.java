package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.strategy.RandomNumberGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy() {
            @Override
            public List<Integer> generateNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        this.lottoStore = new LottoStore(numberGenerateStrategy);
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다")
    @Test
    void purchaseLotto() {
        Lottos lottos = lottoStore.purchaseLotto(new Money(3000));

        assertThat(lottos).isEqualTo(
                new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                ))
        );
    }
}
