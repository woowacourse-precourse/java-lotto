package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 크기를 확인한다.")
    void size_ShouldReturnTrueIsEqualSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest를 통해 인자를 전달받아 같은 테스트를 여러번 반복하지 않는다.")
    void contains_ShouldReturnTrueForContainingNumberFromValueSource(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest()
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource를 활용해 결과값이 다른 인자를 전달받아 다른 결과값을 확인한다.")
    void contains_ShouldReturnTrueForContainingNumberFromCsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
