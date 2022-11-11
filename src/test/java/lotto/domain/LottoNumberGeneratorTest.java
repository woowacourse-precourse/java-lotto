package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    void 랜덤_로또_생성() {
        Lotto lotto = new Lotto(lottoNumberGenerator.generateNumber());
        assertThatNoException();
    }

}
