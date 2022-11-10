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

    @DisplayName("로또를 당첨 번호와 비교하여 등수에 들지 못했을때를 테스트")
    @Test
    void compareWithWinningLottoResultNull()
    {
        List<Integer> lottoNumbers = List.of(1,4,5,6,7,22);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(6,2,34,35,41,44);
        Integer bonusNumber = 22;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(null);
    }

    @DisplayName("3개를 정상적으로 맞췄을 때 테스트")
    @Test
    void resultFifth()
    {
        List<Integer> lottoNumbers = List.of(8,16,26,29,31,36);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(2,8,22,26,31,43);
        Integer bonusNumber = 11;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Fifth);
    }

    @DisplayName("3개를 정상적으로 맞췄을 때 보너스 번호를 맞춰도 5등인지 테스트")
    @Test
    void resultFifthWithBonusNumber()
    {
        List<Integer> lottoNumbers = List.of(8,11,26,29,31,36);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(2,8,22,26,31,43);
        Integer bonusNumber = 11;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Fifth);
    }

    @DisplayName("4개를 정상적으로 맞췄을 때 테스트")
    @Test
    void resultFourth()
    {
        List<Integer> lottoNumbers = List.of(12,30,32,37,39,41);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(12,22,30,32,37,42);
        Integer bonusNumber = 24;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Fourth);
    }

    @DisplayName("4개를 정상적으로 맞추고 보너스 숫자를 맞춰도 4등인지 테스트")
    @Test
    void resultFourthWithBonusNumber()
    {
        List<Integer> lottoNumbers = List.of(12,30,32,37,39,41);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(12,22,30,32,37,42);
        Integer bonusNumber = 41;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Fourth);
    }

    @DisplayName("5개를 정상적으로 맞췄을 때 테스트")
    @Test
    void resultThird()
    {
        List<Integer> lottoNumbers = List.of(3,9,10,29,40,45);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(3,9,15,29,40,45);
        Integer bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Third);
    }

    @DisplayName("5개를 정상적으로 맞추고 보너스 숫자를 맞추면 2등인지 테스트")
    @Test
    void resultSecond()
    {
        List<Integer> lottoNumbers = List.of(3,9,7,29,40,45);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(3,9,15,29,40,45);
        Integer bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.Second);
    }

    @DisplayName("6개를 정상적으로 맞췄을 때 테스트")
    @Test
    void resultFirst()
    {
        List<Integer> lottoNumbers = List.of(2,21,28,38,42,45);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningLottoNumbers = List.of(2,21,28,38,42,45);
        Integer bonusNumber = 30;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,bonusNumber);
        Assertions.assertThat(lottoComparator.compare(lotto,winningLotto)).isEqualTo(Prize.First);
    }
}
