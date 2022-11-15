package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set의 사이즈가 중복을 제거하는지 테스트한다")
    void size_메소드를_통해_집합의_크기_테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    void contains_메소드를_통해_값을_가지고있는지_테스트(int target) {
        assertThat(numbers.contains(target)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void 서로다른_값에_대해_contains_메소드가_잘_작동하는지_테스트(int target, boolean expected) {
        assertThat(numbers.contains(target)).isEqualTo(expected);
    }
}
