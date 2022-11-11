package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void init() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }
    @DisplayName("로또 구입 수만큼 번호 생성되는지 테스트")
    @Test
    void checkSize() {
        List<List<Integer>> lottoNumbers = lottoNumberGenerator.generateLottoNumber(5);
        Assertions.assertThat(lottoNumbers.size()).isSameAs(5);
    }
}