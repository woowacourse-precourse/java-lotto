package lotto.layer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final Table table = new Table();
    private final LottoService lottoService = new LottoService(table);

    @DisplayName("금액/1000 만큼 로또가 생성되야함")
    @Test
    void lottoServiceGenerateLotteriesByMoney() {
        // given
        int price = 2000;
        Money money = new Money(price);

        // when
        List<Lotto> lotteries = lottoService.generateLotteries(money);

        // then
        assertThat(lotteries.size()).isEqualTo(price / 1000);
    }

    @DisplayName("생성된 로또 영속화 테스트")
    @Test
    void lottoServicePersistTest() {
        // given
        int price = 2000;
        Money money = new Money(price);

        // when
        List<Lotto> lotteries = lottoService.generateLotteries(money);
        List<Lotto> tableLotteries = table.getLotteries();

        // then
        assertThat(lotteries.size()).isEqualTo(tableLotteries.size());
    }
}