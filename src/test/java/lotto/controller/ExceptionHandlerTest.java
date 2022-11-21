package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    @Test
    void testValidNumberRange() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validNumberRange(46);
        });
    }

    @Test
    void testValidNumbersLength() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validNumbersLength(List.of(1,2));
        });

        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validNumbersLength(List.of(1,2,3,3,4,4,5));
        });
    }

    @Test
    void testValidNumbersDupplication() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validNumbersDupplication(List.of(1,2,2,2));
        });
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validNumbersDupplication(List.of(1,1));
        });
    }

    @Test
    void testValidPurchaseForm() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.validPurchaseForm("1200");
        });
    }

    @Test
    void excParseInt() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.excParseInt("@");
        });
    }

}