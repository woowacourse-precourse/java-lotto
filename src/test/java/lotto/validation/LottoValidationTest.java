package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {
    @Test
    @DisplayName("제대로 된 숫자 리스트를 줄때 Exception이 나면 안된다.")
    void rightDoesNotException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // expected
        assertDoesNotThrow(() ->LottoValidation.checkValidation(numbers));
    }

    @Test
    @DisplayName("6개가 아닌 리스트를 주면 IllegalArgumentException과 메세지가 출력되어야 한다.")
    void notSixNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LottoValidation.checkValidation(numbers)
        );
        assertEquals("[ERROR] 생성 된 로또가 6개의 숫자가 아닙니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자 리스트를 주면 IllegalArgumentException과 메세지가 출력되어야 한다.")
    void duplicated() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LottoValidation.checkValidation(numbers)
        );
        assertEquals("[ERROR] 생성 된 로또에 중복된 숫자가 존재합니다.", exception.getMessage());
    }
}