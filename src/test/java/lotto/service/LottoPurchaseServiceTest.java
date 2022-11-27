package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseServiceTest {

    @Nested
    @DisplayName("구매금액 입력오류시, 생성 예외발생")
    class CreateTest {

        String purchaseAmount;

        @DisplayName("구매금액 정상일 경우")
        @Test
        void test1() {
            purchaseAmount = "78000";
            assertDoesNotThrow(() -> new LottoPurchaseService(purchaseAmount));

            purchaseAmount = "1000";
            assertDoesNotThrow(() -> new LottoPurchaseService(purchaseAmount));
        }

        @DisplayName("구매금액이 문자를 포함할 경우 예외를 발생")
        @Test
        void test2() {
            purchaseAmount = "10O00";
            assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseService(purchaseAmount));
        }

        @DisplayName("구매금액이 1000원 단위가 아닐 경우 예외를 발생")
        @Test
        void test3() {
            purchaseAmount = "500";
            assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseService(purchaseAmount));

            purchaseAmount = "34200";
            assertThrows(IllegalArgumentException.class, () -> new LottoPurchaseService(purchaseAmount));
        }

    }

    @DisplayName("13000원 구매시, 13개의 로또가 발행되어야 한다.")
    @Test
    void issueLotteries() {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService("13000");
        List<Lotto> lotteries = lottoPurchaseService.issueLotteries();
        assertThat(13).isEqualTo(lotteries.size());
    }

}