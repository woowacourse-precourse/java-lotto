package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        LottoNumberGenerateStrategy lottoNumberGenerateStrategy = new RandomLottoNumberGenerateStrategy() {
            @Override
            public List<LottoNumber> generateNumbers() {
                return List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
            }
        };

        this.lottoStore = new LottoStore(lottoNumberGenerateStrategy);
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다")
    @Test
    void purchaseLotto() {
        List<Lotto> lottos = lottoStore.purchaseLotto(new Money(3000));

        assertThat(lottos).isEqualTo(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));
    }
}
