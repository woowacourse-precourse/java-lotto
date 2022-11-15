package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceTest {

    Price price;

    @DisplayName("입력값이 문자를 포함하는지 확인")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"100a", "abcd", "100!", "100-"})
    void includeCharacter(String input) {
        try {
            price = new Price(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.NOT_INCLUDE_CHARACTER.toString(), e.getMessage());
        }
    }

    @DisplayName("입력값이 천 단위가 아닐 때")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"123", "1234", "12345", "123456", "1234567"})
    void notDividedBy1000(String input) {
        try {
            price = new Price(input);
        } catch (IllegalArgumentException e) {
            assertEquals(Errors.NOT_DIVIDE_BY_1000.toString(), e.getMessage());
        }
    }

}
