package lotto.model;

import lotto.model.numbers.LottoStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = LottoStore.buyTicketsByBudget(8_000);
    }

    @Nested
    class validInput {

        @Test
        void 정상_구매() {
            Assertions.assertEquals(8, lottoStore.getTicketNumber());
        }
    }

}