package Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @Nested
    @DisplayName("IsMultipleOfOneThousand 메소드 테스트")
    class TestIsMultipleOfOneThousand {
        @Test
        @DisplayName("입력값이 1000원 단위로 떨어지는 경우")
        void case1() {
            String input = "10000";
            boolean result = InputUtils.isMultipleOfOneThousand(input);
            assertThat(result).isTrue();
        }
        @Test
        @DisplayName("입력값이 1000원 단위로 떨어지지 않는 경우")
        void case2() {
            String input = "1300";
            boolean result = InputUtils.isMultipleOfOneThousand(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isNumberLengthSix 메소드 테스트")
    class TestIsNumberLengthSix {
        @Test
        @DisplayName("당첨 번호가 6자리인 경우")
        void case1() {
            List<Integer> input = List.of(1, 3, 34, 23, 12, 4);
            boolean result = InputUtils.isNumberLengthSix(input);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("당첨 번호가 6자리가 아닌 경우")
        void case2() {
            List<Integer> input = List.of(1, 3, 34);
            boolean result = InputUtils.isNumberLengthSix(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isNumberSplitWithComma 메소드 테스트")
    class TestIsNumberSplitWithComma {
        @Test
        @DisplayName("당첨 번호가 쉼표로 구분되어 있는 경우")
        void case1() {
            String input = "1,2,3,4,5,6";
            boolean result = InputUtils.isNumberSplitWithComma(input);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("쉼표가 아닌 다른 기호로 구분되어 있는 경우")
        void case2() {
            String input = "1/2/3/4/5/6";
            boolean result = InputUtils.isNumberSplitWithComma(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isDigit 메소드 테스트")
    class TestIsDigit {
        @Test
        @DisplayName("입력값이 정수인 경우")
        void case1() {
            String input = "35";
            boolean result = InputUtils.isDigit(input);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("입력값이 정수가 아닌 경우")
        void case2() {
            String input = "숫자..?";
            boolean result = InputUtils.isDigit(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isNumberInLottoRange 메소드 테스트")
    class TestIsNumberInLottoRange {
        @Test
        @DisplayName("숫자가 1~45 사이의 범위에 존재하는 경우")
        void case1() {
            String input = "1";
            boolean result = InputUtils.isNumberInLottoRange(input);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("입력값이 1~45 범위에 속하지 않는 경우")
        void case2() {
            String input = "100";
            boolean result = InputUtils.isNumberInLottoRange(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("listToString 메소드 테스트")
    class TestListToString {
        @Test
        @DisplayName("정수 리스트를 문자열로 변환합니다.")
        void case1() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            String expected = "[1, 2, 3, 4, 5, 6]";
            String result = InputUtils.listToString(numbers);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("stringToInteger 메소드 테스트")
    class TestStringToInteger {
        @Test
        @DisplayName("문자열을 정수로 변환합니다.")
        void case1() {
            String input = "13";
            Integer expected = 13;
            Integer result = InputUtils.stringToInteger(input);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("stringToIntegerList 메소드 테스트")
    class TestStringToIntegerList {
        @Test
        @DisplayName("쉼표가 포함된 문자열을 정수 리스트로 변환합니다.")
        void case1() {
            String input = "1,2,3,4,5,6";
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> result = InputUtils.stringToIntegerList(input);
            assertThat(result).isEqualTo(expected);
        }
    }
}