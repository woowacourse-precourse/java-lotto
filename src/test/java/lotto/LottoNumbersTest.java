package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 6개 일치하는 경우 상금 확인")
    void compareResultTest() {
        List<Lotto> lottoNumber = new ArrayList<>();
        lottoNumber.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoBonusNumber("7"));
        Results results = new Results();
        assertThat(2000000000).isEqualTo(lottoNumbers.compareResult(lottoWinningNumber, results));
    }

}