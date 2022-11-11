package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
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
    @DisplayName("Set의 크기 확인")
    void size() {
        assertThat(numbers).hasSize(3);
    }
    
    @DisplayName("Set의 각 요소가 존재하는지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(final int value) {
        assertThat(numbers).contains(value);
    }
}
