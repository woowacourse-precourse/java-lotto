package lotto.model;

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

    @DisplayName("당첨 로또와 보너스 번호를 받고 수익 계산")
    @Test
    void get_Profit_Sum() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumbers.addLotto(new Lotto(List.of(2, 3, 4, 5, 8, 9)));
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.getProfitSum(targetLotto, 8)).isEqualTo(2_000_050_000);

        lottoNumbers.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        assertThat(lottoNumbers.getProfitSum(targetLotto, 8)).isEqualTo(2_030_050_000);
    }
}
