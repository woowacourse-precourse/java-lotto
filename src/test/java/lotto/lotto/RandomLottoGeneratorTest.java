package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {
    @Test
    public void generateSuccessTest() throws Exception {
        // given
        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        // when

        // then
        assertThatCode(lottoGenerator::generate).doesNotThrowAnyException();
    }
}