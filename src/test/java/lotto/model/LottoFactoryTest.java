package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {
    LottoFactory lottoFactory;
    @BeforeEach
    void 전처리() {
        lottoFactory = new LottoFactory();
    }
    @ParameterizedTest
    @CsvSource({"1,1", "10,10"})
    void 사용자_로또를_n개_생성하는_기능(int expected, int actual) {
        Lottos lottos = lottoFactory.generate(actual);
        assertThat(lottos.getSize()).isEqualTo(expected);
    }
}