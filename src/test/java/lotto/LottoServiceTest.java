package lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.money.Money;
import lotto.global.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    LottoService lottoService = new AppConfig().lottoService();

    @Nested
    @DisplayName("금액에 맞는 로또 구매하기")
    class buyLottos {
        @Test
        @DisplayName("2000원 어치의 로또를 구매하면 6개의 숫자가 포함된 로또 2개가 생성된다.")
        void success()  {
            //given
            final Money money = Money.create(2000);
            //when
            final Lottos lottos = lottoService.buyLottos(money);
            //then
            assertThat(lottos.size()).isEqualTo(2);
            assertThat(lottos.getLottos().get(1).getNumbers().size()).isEqualTo(6);
        }
    }
}
