package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceTest {

    Price price;

    @ParameterizedTest
    @CsvSource({"123", "1234", "12345", "123456", "1234567"})
    void 천단위가_아닐때(String input) {
        try {
            price = new Price(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.NOT_DIVIDE_BY_1000.toString(), e.getMessage());
        }
    }

}
