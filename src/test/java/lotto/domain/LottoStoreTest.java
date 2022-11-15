package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoStoreTest {

    @DisplayName("로또 구매 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    void purchaseLottoTest(int purchaseAmount) {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottoTickets = lottoStore.buy(purchaseAmount);

        assertEquals(purchaseAmount / 1000, lottoTickets.size());
        assertTrue(lottoTickets.stream()
                .allMatch(lottoTicket -> lottoTicket.getNumbers().stream().distinct().count() == 6));
    }

}