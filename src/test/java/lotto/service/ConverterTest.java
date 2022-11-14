package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    @Test
    @DisplayName("쉼표를 기준으로 나누고, 정렬된 List를 반환한다.")
    void splitByComma() {
        // given
        String input = "1,3,42,32,25,7";

        // when
        List<Integer> numbers = Converter.convertStringToNumbers(input);

        // then
        assertEquals(List.of(1, 3, 7, 25, 32, 42), numbers);
    }
}
