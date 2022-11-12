package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoNumberGenerateStrategyTest {
    private LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    @BeforeEach
    void setUp() {
        this.lottoNumberGenerateStrategy = new RandomLottoNumberGenerateStrategy() {
            @Override
            public List<LottoNumber> generateNumbers() {
                return List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
            }
        };
    }

    @DisplayName("1부터 45 임의의 숫자 6개를 생성한다.")
    @Test
    void generateNumber() {
        assertThat(lottoNumberGenerateStrategy.generateNumbers())
                .containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}
