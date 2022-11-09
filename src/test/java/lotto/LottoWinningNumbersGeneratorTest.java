package lotto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningNumbersGeneratorTest {

    @Test
    void 로또_당첨_번호_생성() {
        List<Integer> lottoWinningNumbers = LottoWinningNumbersGenerator.generateLottoWinningNumbers();

        assertThat(lottoWinningNumbers).isNotEmpty();
    }
}