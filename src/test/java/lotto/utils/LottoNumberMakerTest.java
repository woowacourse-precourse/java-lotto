package lotto.utils;

import lotto.domains.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberMakerTest {
    @Test
    void createLottoNumbersTest() {
        Lotto lottoNumbers = LottoNumberMaker.createLottoNumbers();
        assertThat(lottoNumbers.getNumbers()).isNotNull();
    }

}
