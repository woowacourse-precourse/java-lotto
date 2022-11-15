package lotto;

import static lotto.constant.Rules.LOTTO_PRICE;
import static lotto.money.Money.createPurchaseMoney;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.money.PurchaseMoneyNotDividedByPriceException;
import lotto.exception.money.PurchaseMoneyNotPositiveIntegerException;
import lotto.exception.money.PurchaseMoneyRangeException;
import lotto.money.Money;
import lotto.money.Yield;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("수익률은 총 수익에 로또 구입 금액을 나눈 후 100을 곱해준 값이며, 소수점 둘째자리에서 소수점해서 나타낸다.")
    @Test
    void yieldTwoPointRound() {
        Yield yield1 = new Yield(Money.createPurchaseMoney("5000"), new Money(50000));
        Yield yield2 = new Yield(Money.createPurchaseMoney("5000"), new Money(5000));
        Yield yield3 = new Yield(Money.createPurchaseMoney("5000"), new Money(0));
        Yield yield4 = new Yield(Money.createPurchaseMoney("5000"), new Money(625));

        Assertions.assertThat(yield1.toString()).isEqualTo("1000.0%");
        Assertions.assertThat(yield2.toString()).isEqualTo("100.0%");
        Assertions.assertThat(yield3.toString()).isEqualTo("0.0%");
        Assertions.assertThat(yield4.toString()).isEqualTo("12.5%");
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDividedByPrice() {
        assertThatThrownBy(() -> createPurchaseMoney("1400"))
                .isInstanceOf(PurchaseMoneyNotDividedByPriceException.class);
    }

    @DisplayName("구입 금액이 로또 1장 가격보다 작으면 예외가 발생한다.")
    @Test
    void moneyUnderLottoPrice() {
        assertThatThrownBy(() -> createPurchaseMoney("900"))
                .isInstanceOf(PurchaseMoneyRangeException.class);
    }

    @DisplayName("로또 장수는 구입 금액에서 로또 1장 가격을 나눈 값이다.")
    @Test
    void calculateLottoCount() {
        Money money = createPurchaseMoney(Integer.toString(3 * LOTTO_PRICE));
        assertThat(money.calculateLottoCount()).isEqualTo(3);
    }

    @DisplayName("구입 금액이 양의 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createMoneyNotPositiveInteger() {
        assertThatThrownBy(() -> createPurchaseMoney("-1"))
                .isInstanceOf(PurchaseMoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("a100"))
                .isInstanceOf(PurchaseMoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("100a"))
                .isInstanceOf(PurchaseMoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("0"))
                .isInstanceOf(PurchaseMoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("abc"))
                .isInstanceOf(PurchaseMoneyNotPositiveIntegerException.class);
    }
}
