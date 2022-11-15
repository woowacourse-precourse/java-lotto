package lotto.model.resources;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {

    Money money;

    @Test
    void Money_클래스에서_1000_나눠서_반환() {
        String moneyMaterial = "11000";
        int result = 11;
        money = new Money(moneyMaterial);
        Assertions.assertThat(money.moneyDivide1000()).isEqualTo(result);
    }

    @Test
    void Money_클래스에_숫자가_아닌_문자열_입력() {
        String moneyMaterial1 = "11000ㅓ";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial1);
        }).hasMessageContaining("[ERROR] 숫자를 입력해야 합니다. - Money");

        String moneyMaterial2 = "11000j";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial2);
        }).hasMessageContaining("[ERROR] 숫자를 입력해야 합니다. - Money");
    }

    @Test
    void Money_클래스에_1000으로_나눠_떨어지지_않는_숫자_입력() {
        String moneyMaterial1 = "11001";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial1);
        }).hasMessageContaining("[ERROR] 1000원 단위의 금액을 입력해야 합니다. - Money");

        String moneyMaterial2 = "1";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial2);
        }).hasMessageContaining("[ERROR] 1000원 단위의 금액을 입력해야 합니다. - Money");
    }

    @Test
    void Money_클래스에_금액으로_음수_입력() {
        String moneyMaterial1 = "-1000";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial1);
        }).hasMessageContaining("[ERROR] 알맞은 금액을 입력하세요. - Money");

        String moneyMaterial2 = "-1001";
        Assertions.assertThatThrownBy(() -> {
            money = new Money(moneyMaterial2);
        }).hasMessageContaining("[ERROR] 알맞은 금액을 입력하세요. - Money");
    }
}