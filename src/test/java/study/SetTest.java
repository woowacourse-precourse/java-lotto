package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("요구사항 1")
    class Requirement1 {

        @Test
        @DisplayName("Set의 사이즈 확인하기")
        void test1() {
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Requirement2 {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다")
        void test1(int value) {
            assertThat(numbers.contains(value)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Requirement3 {
        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        void test1(int input, boolean expected) {
            // when
            boolean actualValue = numbers.contains(input);

            // then
            assertThat(actualValue).isEqualTo(expected);
        }
    }
    
}
