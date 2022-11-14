package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
    @ParameterizedTest(name="구매 금액에 문자 포함 확인")
    @ValueSource(strings={"40i", "기9"})
    void isMoneyNumberTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Money.isMoneyNumber(input);
        });
    }
    @ParameterizedTest(name="구매 금액이 유효한지 확인")
    @ValueSource(ints={0, 365, 10000004})
    void isMoneyValidTest(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Money.isMoneyValid(input);
        });
    }

}