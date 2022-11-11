package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Set의 size() 메소드가 올바른 Set의 크기를 반환하는지 확인")
    void 요구사항1() {
        int setSize = numbers.size();

        assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 요구사항2(int argument) {
        assertTrue(numbers.contains(argument));
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값은 존재하고, 4,5의 값이 존재하지 않는 것을 확인")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void 요구사항3(int input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);
    }
}
