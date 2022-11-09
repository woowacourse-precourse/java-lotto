package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Set의 size 메서드로 Set의 크기를 확인")
    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains 메서드로 매개값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkInclusionWithValueSource(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains 메서드 사용 시 매개값에 따라 true 또는 false를 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkInclusionWithCsvSource(int input, boolean expectedResult) {
        assertThat(numbers.contains(input)).isEqualTo(expectedResult);
    }
}
