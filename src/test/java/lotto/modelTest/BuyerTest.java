package lotto.modelTest;

import lotto.model.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    @DisplayName("구매 금액을 최소 금액 단위로 나누어 티켓의 수를 맞게 구하는지 확인한다.")
    public void createTicketTest() {
        List<Integer> purchaseAmounts = List.of(10000, 12000, 1000, 3000, 4000);
        List<Integer> resultPurchaseAmounts = new ArrayList<>();

        for (int purchaseAmount : purchaseAmounts) {
            resultPurchaseAmounts.add(purchaseAmount / 1000);
        }
        assertThat(resultPurchaseAmounts).containsExactly(10, 12, 1, 3, 4);
    }

    @Test
    @DisplayName("최소 금액 단위 이하의 금액이 포함된 구매 금액을 최소 금액 단위로 나누어 티켓의 수를 맞게 구하는지 확인한다.")
    public void createTicketUnderUnitAmountTest() {
        List<Integer> purchaseAmounts = List.of(10000, 12000, 1000, 3000, 4000, 4500, 5500);
        List<Integer> resultPurchaseAmounts = new ArrayList<>();

        for (int purchaseAmount : purchaseAmounts) {
            resultPurchaseAmounts.add(purchaseAmount / 1000);
        }
        assertThat(resultPurchaseAmounts).containsExactly(10, 12, 1, 3, 4, 4, 5);
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 최소 금액 단위인지 확인한다.")
    @ValueSource(strings = {"10500", "10010", "10001"})
    public void validateProperUnitAmountTest(String purchaseAMount) {
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.validateProperUnitAmount(purchaseAMount)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구매 금액에 다른 문자가 있다면 예외가 발생한다.")
    @ValueSource(strings = {"1050e", "10010 1000", "A000["})
    public void validateProperLettersTest(String purchaseAMount) {
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.validateProperLetters(purchaseAMount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("String 자료형인 구매 금액을 정수형으로 변환한다.")
    public void changeTypeTest() {
        Buyer buyer = new Buyer();
        List<String> purchaseAmounts = List.of("10000", "30000", "12000");
        List<Integer> transformedPurchaseAmount = new ArrayList<>();
        for (String purchaseAmount : purchaseAmounts) {
            transformedPurchaseAmount.add(buyer.changeType(purchaseAmount));
        }
        assertThat(transformedPurchaseAmount).containsExactly(10000, 30000, 12000);
    }
}
