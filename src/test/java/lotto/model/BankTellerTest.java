package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTellerTest {
    @Test
    void checkLottosTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 12)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 3, 12, 13, 14)));
        lottos.add(new Lotto(List.of(1, 2, 11, 12, 13, 14)));
        lottos.add(new Lotto(List.of(1, 15, 11, 12, 13, 14)));
        lottos.add(new Lotto(List.of(16, 15, 11, 12, 13, 14)));
        String winningLotto = "1,2,3,4,5,6";
        String bonusNumber = "7";

        Customer customer = new Customer();
        customer.setLottos(lottos);

        LottoCompany lottoCompany = new LottoCompany();
        lottoCompany.setWinningLotto(winningLotto);
        lottoCompany.setBonusNumber(bonusNumber);

        BankTeller bankTeller = new BankTeller();
        List<LottoRank> lottoRanks = bankTeller.checkLottos(customer, lottoCompany);
        assertThat(lottoRanks).isEqualTo(List.of(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.FORTH,
                LottoRank.FIFTH,
                LottoRank.NOTHING,
                LottoRank.NOTHING,
                LottoRank.NOTHING
        ));
    }

    @Test
    void calculatePrizeTest() {
        List<LottoRank> lottoRanks = new ArrayList<>(List.of(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.FORTH,
                LottoRank.FIFTH,
                LottoRank.NOTHING,
                LottoRank.NOTHING,
                LottoRank.NOTHING
        ));
        BankTeller bankTeller = new BankTeller();
        int prize = bankTeller.calculatePrize(lottoRanks);
        assertThat(prize).isEqualTo(2031555000);
    }

    @DisplayName("로또를 구입하지 않은 경우")
    @Test
    void calculatePrizeTest2() {
        List<LottoRank> lottoRanks = new ArrayList<>(List.of());
        BankTeller bankTeller = new BankTeller();
        int prize = bankTeller.calculatePrize(lottoRanks);
        assertThat(prize).isEqualTo(0);
    }

    @Test
    void calculateROITest() {
        BankTeller bankTeller = new BankTeller();
        double roi = bankTeller.calculateROI(2031555000, 8000);
        assertThat(roi).isEqualTo(2031555000./8000.);
    }
}