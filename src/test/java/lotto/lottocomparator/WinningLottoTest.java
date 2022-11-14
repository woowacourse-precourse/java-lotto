package lotto.lottocomparator;

import lotto.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.lottocomparator.LottoComparator.judgeAllLotto;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * WinningLotto 클래스와 관련된 테스트 클래스입니다.
 */
class WinningLottoTest {

    /**
     * 수익률 계산 테스트입니다.
     */
    @Test
    void getRateOfRevenue() {
        LottoNumber winningLotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<LottoNumber> userLotto = new ArrayList<>();
        userLotto.add(new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(3, 5, 11, 16, 32, 38, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(7, 11, 16, 35, 36, 44, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(1, 8, 11, 31, 41, 42, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(13, 14, 16, 38, 42, 45, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(7, 11, 30, 40, 42, 43, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(2, 13, 22, 32, 38, 45, -1)));
        userLotto.add(new LottoNumber(Arrays.asList(1, 3, 5, 14, 22, 45, -1)));
        WinningLotto result = judgeAllLotto(winningLotto, userLotto);
        assertThat(result.getRateOfRevenue()).isEqualTo(62.5);
    }
}