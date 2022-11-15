package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersGeneratorTest {

    @Test
    void 로또_당첨_번호_생성() {
        List<Integer> lottoWinningNumbers = LottoNumbersGenerator.generateLottoNumbers();

        assertThat(lottoWinningNumbers).isNotEmpty();
    }
}