package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("로또 당첨상태 추가")
    @Test
    void add_lotto_status() {
        LottoNumbers lottoNumbers = new LottoNumbers(9);
        lottoNumbers.addStatus(LottoStatus.MATCH_FIVE);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FIVE)).isEqualTo(1);

        lottoNumbers.addStatus(LottoStatus.MATCH_FIVE);
        assertThat(lottoNumbers.getStatusCount(LottoStatus.MATCH_FIVE)).isEqualTo(2);
    }
}
