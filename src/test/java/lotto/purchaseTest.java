package lotto;

import lotto.domain.Lotto;
import lotto.service.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class purchaseTest {

    @Nested
    @DisplayName("구매금액 입력오류시, 생성 예외발생")
    class CreateTest {

        String purchaseAmount;

        @DisplayName("구매금액 정상일 경우")
        @Test
        void test1() {
            purchaseAmount = "78000";
            assertDoesNotThrow(() -> new Purchase(purchaseAmount));

            purchaseAmount = "1000";
            assertDoesNotThrow(() -> new Purchase(purchaseAmount));
        }

        @DisplayName("구매금액이 문자를 포함할 경우 예외를 발생")
        @Test
        void test2() {
            purchaseAmount = "10O00";
            assertThrows(IllegalArgumentException.class, () -> new Purchase(purchaseAmount));
        }

        @DisplayName("구매금액이 1000원 단위가 아닐 경우 예외를 발생")
        @Test
        void test3() {
            purchaseAmount = "500";
            assertThrows(IllegalArgumentException.class, () -> new Purchase(purchaseAmount));

            purchaseAmount = "34200";
            assertThrows(IllegalArgumentException.class, () -> new Purchase(purchaseAmount));
        }

    }

    @DisplayName("13000원 구매시, 13개의 로또가 발행되어야 한다.")
    @Test
    void issueLotteries() {
        Purchase Purchase = new Purchase("13000");
        List<Lotto> lotteries = Purchase.issueLotteries();
        assertThat(13).isEqualTo(lotteries.size());
    }

}