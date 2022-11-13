package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSalesmanTest {
    @DisplayName("로또 구매 수량만큼의 로또를 발행한다")
    @Test
    void salesLottoByCorrectQuantity() {
        List<Lotto> lotteries = LottoSalesman.sales(14000);
        assertThat(lotteries.size()).isEqualTo(14);
    }
}
