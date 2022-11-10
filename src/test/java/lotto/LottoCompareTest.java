package lotto;

import lotto.Lotto.Lotto;
import lotto.Lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoCompareTest {

    public static LottoComparator lottoComparator;

    @BeforeAll
    static void init()
    {
        lottoComparator = new LottoComparator();
    }

    @DisplayName("로또를 당첨 번호와 비교하는 테스트")
    @Test
    void compareWithWinningLotto()
    {
        List<Integer> lottoNumbers = List.of(1,4,5,6,7,22);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(6,2,34,35,41,44);
        Integer bonusNumber = 22;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(null);
    }
}
