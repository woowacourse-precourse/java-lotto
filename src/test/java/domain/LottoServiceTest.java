package domain;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구매 개수만큼 로또 반환 테스트")
    @Test
    void publishLottoTest() {
        List<Lotto> lottos = lottoService.publishLotto(10);

        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.getUserLottoNumbers().size()).isEqualTo(6);
        }

        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("구매한 로또 개수 반환 테스트")
    @Test
    void getNumberOfLottoTest() {
        String moneyInput = "10000";
        int numberOfLotto = lottoService.getNumberOfLotto(moneyInput);

        Assertions.assertThat(numberOfLotto).isEqualTo(10);

    }
}
