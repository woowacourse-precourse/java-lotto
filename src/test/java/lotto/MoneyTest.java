package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {
    @Test
    @DisplayName("1000단위로 돈이 들어오지 않았을 때 예외를 처리한다.")
    void if_not_divide_1000(){
        try {
            new Money(1234);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("[ERROR]"));
        }    }
}
