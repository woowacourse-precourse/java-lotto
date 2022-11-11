package study;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("set 크기 테스트")
    void setSizeTest() {
        assertThat(numbers)
                .size()
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set contain 메서드 테스트")
    void contains(int value) {
        assertThat(numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false"})
    @DisplayName("set contain 메서드 성공 / 실패 테스트")
    void conatinsTrueFalse(int number, boolean expected) {
        boolean actualValue = numbers.contains(number);
        assertThat(actualValue).isEqualTo(expected);
    }

}
