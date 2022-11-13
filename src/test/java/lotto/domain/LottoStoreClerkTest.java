package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoStoreClerkTest {
    @Nested
    class SellTest extends NsTest {
        @DisplayName("5000원으로 로또 5개 구매")
        @Test
        void buy5Lottos() {
            run("5000");
            assertThat(output()).contains("5개를 구매했습니다.");
        }

        @DisplayName("0원으로 로또 0개 구매")
        @Test
        void buy0Lotto() {
            run("0");
            assertThat(output()).contains("0개를 구매했습니다.");
        }

        @Override
        protected void runMain() {
            Customer customer = new Customer(new Bag());
            LottoStoreClerk clerk = new LottoStoreClerk(new LottoPrinter());
            clerk.sellLottoTo(customer);
        }
    }
}