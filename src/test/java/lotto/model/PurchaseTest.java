package lotto.model;

import lotto.Enum.Error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @DisplayName("1000으로 나누어 떨어지지 않을 때 예외 발생")
    @Nested
    class UnitTest{
        @Test
        void case1(){
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                Purchase purchase = new Purchase("500");
            });
            assertEquals(Error.UNIT.getMessage(), exception.getMessage());
        }
        @Test
        void case2(){
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                Purchase purchase = new Purchase("1050");
            });
            assertEquals(Error.UNIT.getMessage(), exception.getMessage());
        }
    }
}
