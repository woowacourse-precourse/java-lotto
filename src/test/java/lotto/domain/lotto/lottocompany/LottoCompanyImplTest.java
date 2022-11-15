package lotto.domain.lotto.lottocompany;

import static lotto.domain.lotto.lottocompany.Win.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyImplTest {

    @Test
    @DisplayName("로또 회사는 로또 발행 개수만큼 로또를 발행한다.")
    void publishNLottoTest() {
        //given
        LottoCompany lottoCompany = new LottoCompanyImpl(new LottoMachineImpl());
        int publishLottoCount = 5;

        //when
        List<Lotto> publishNLotto = lottoCompany.publishNLotto(publishLottoCount);

        //then
        assertThat(publishNLotto.size()).isEqualTo(publishLottoCount);
    }

    @Test
    @DisplayName("로또 회사는 발행된 로또의 당첨 내역을 확인한다.")
    void makeWinResultTest() {
        //given
        LottoCompany lottoCompany = new LottoCompanyImpl(new LottoMachineImpl());

        List<String> winningNumbers = List.of("2", "5", "8", "15", "20", "44");
        int bonusNumber = 14;

        Lotto lotto1 = new Lotto(List.of(2, 5, 8, 15, 20, 44));
        Lotto lotto2 = new Lotto(List.of(2, 5, 8, 14, 15, 44));
        Lotto lotto3 = new Lotto(List.of(2, 5, 8, 16, 20, 44));
        Lotto lotto4 = new Lotto(List.of(2, 5, 8, 15, 24, 45));
        Lotto lotto5 = new Lotto(List.of(2, 5, 8, 12, 27, 41));

        List<Lotto> publishedNLotto = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);

        //when
        Map<Win, Integer> winResult = lottoCompany.makeWinResult(publishedNLotto, winningNumbers, bonusNumber);

        //then
        assertThat(winResult.get(first)).isEqualTo(1);
        assertThat(winResult.get(second)).isEqualTo(1);
        assertThat(winResult.get(third)).isEqualTo(1);
        assertThat(winResult.get(fourth)).isEqualTo(1);
        assertThat(winResult.get(fifth)).isEqualTo(1);

    }

    @Test
    @DisplayName("로또 회사는 총 당첨 금액을 계산해서 반환한다.")
    void getTotalPrizeTest() {
        //given
        LottoCompany lottoCompany = new LottoCompanyImpl(new LottoMachineImpl());

        List<String> winningNumbers = List.of("2", "5", "8", "15", "20", "44");
        int bonusNumber = 14;

        Lotto lotto1 = new Lotto(List.of(2, 5, 8, 15, 20, 44));
        Lotto lotto2 = new Lotto(List.of(2, 5, 8, 14, 15, 44));
        Lotto lotto3 = new Lotto(List.of(2, 5, 8, 16, 20, 44));
        Lotto lotto4 = new Lotto(List.of(2, 5, 8, 15, 24, 45));
        Lotto lotto5 = new Lotto(List.of(2, 5, 8, 12, 27, 41));

        List<Lotto> publishedNLotto = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);

        lottoCompany.makeWinResult(publishedNLotto, winningNumbers, bonusNumber);

        //when
        int totalPrize = lottoCompany.getTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(2031555000);
    }
}
