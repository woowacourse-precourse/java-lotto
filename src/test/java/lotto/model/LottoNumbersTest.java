package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {


    @DisplayName("로또 추가")
    @Test
    void add_lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(0);

        Lotto lotto = Lotto.CreatRandomLotto();
        lottoNumbers.addLotto(lotto);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(1);
        assertThat(lottoNumbers.contains(lotto)).isTrue();
    }

    @DisplayName("자동 생성 로또를 수량만큼 추가")
    @Test
    void add_random_lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addRandomLotto(5);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(5);

        lottoNumbers.addRandomLotto(3);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(8);
    }

    @DisplayName("로또 당첨상태 추가")
    @Test
    void add_lotto_status() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addStatus(LottoStatus.MATCH_FIVE);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FIVE)).isEqualTo(1);

        lottoNumbers.addStatus(LottoStatus.MATCH_FIVE);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FIVE)).isEqualTo(2);
    }

    @DisplayName("당첨번호와 비교하여 모든 로또 당청상태를 추가")
    @Test
    void add_all_lotto_status() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumbers.addLotto(new Lotto(List.of(2, 3, 4, 5, 8, 9)));

        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.addAllStatus(targetLotto,1);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_SIX)).isEqualTo(1);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FIVE)).isEqualTo(0);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FOUR)).isEqualTo(1);
    }

    @DisplayName("수익 계산")
    @Test
    public void get_profit_sum() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addStatus(LottoStatus.MATCH_FOUR);
        assertThat(lottoNumbers.getProfitSum()).isEqualTo(MATCH_FOUR_PROFIT);
        lottoNumbers.addStatus(LottoStatus.MATCH_FIVE);
        assertThat(lottoNumbers.getProfitSum()).isEqualTo(MATCH_FOUR_PROFIT+MATCH_FIVE_PROFIT);
    }
}
