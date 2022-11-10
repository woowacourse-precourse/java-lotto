package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("로또를 수량만큼 추가")
    @Test
    void add_lotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addLotto(5);
        assertThat(lottoNumbers.getLottoQuantity()).isEqualTo(5);

        lottoNumbers.addLotto(3);
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

    @DisplayName("모든 로또 당청상태를 추가")
    @Test
    void add_all_lotto_status(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addLotto(5);
        lottoNumbers.addAllStatus();
        assertThat(lottoNumbers.getAllStatusCount()).isEqualTo(5);
    }
}
