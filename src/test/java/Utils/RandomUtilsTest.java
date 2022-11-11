package Utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


class RandomUtilsTest {
    @Nested
    @DisplayName("GetRandomLottoNumber 메소드 테스트")
    class TestGetRandomLottoNumber {

        @Test
        @DisplayName("1~45사이의 6자리 랜덤 숫자 생성을 확인합니다.")
        void case1() {
            List<Integer> numbers = RandomUtils.getRandomLottoNumber();
            Set<Integer> set = new HashSet<>(numbers);
            assertThat(numbers.size()).isEqualTo(6); // 길이 확인
            assertThat(numbers.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue(); // 숫자 범위 확인
            assertThat(numbers.size()).isEqualTo(set.size()); // 숫자 중복 확인
        }
    }

    @Nested
    @DisplayName("isUniqueNumber 메소드 테스트")
    class TestIsUniqueNumber {

        @Test
        @DisplayName("중복되지 않은 로또 숫자인 경우")
        void case1() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            boolean result = RandomUtils.isUniqueNumber(numbers);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("중복된 로또 숫자가 입력될 경우")
        void case2() {
            List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3);
            boolean result = RandomUtils.isUniqueNumber(numbers);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isUniqueBonusNumber 메소드 테스트")
    class TestIsUniqueBonusNumber {

        @Test
        @DisplayName("입력된 보너스 번호가 로또 번호와 중복되지 않을 경우")
        void case1() {
            int number = 1;
            boolean result = RandomUtils.isUniqueBonusNumber(number);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("입력된 보너스 번호가 로또 번호와 중복되는 경우")
        void case2() {
            int number = 1;
            boolean result = RandomUtils.isUniqueBonusNumber(number);
            assertThat(result).isFalse();
        }
    }
}