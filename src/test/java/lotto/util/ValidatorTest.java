package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {

    @Nested
    class IsNumber {
        @DisplayName("주어진 문자열이 숫자가 아닌 경우 False를 반환한다.")
        @Test
        void isNumberTest_숫자가아닌경우() {
            String input = "asdfadf1";

            Assertions.assertThat(Validator.isNumber(input)).isFalse();
        }

        @DisplayName("주어진 문자열이 숫자인 경우 True를 반환한다.")
        @Test
        void isNumberTest_숫자인경우() {
            String input = "1234";

            Assertions.assertThat(Validator.isNumber(input)).isTrue();
        }
    }

    @Nested
    class IsInRangeForList {
        @DisplayName("주어진 리스트 중 특정 숫자가 범위 밖에 있는 경우 False를 반환한다.")
        @Test
        void isInRange_범위밖인경우() {
            Assertions.assertThat(Validator.isInRange(List.of(0,1,2,3,4,5))).isFalse();

        }

        @DisplayName("주어진 리스트의 모든 숫자가 범위 내인 경우 True를 반환한다.")
        @Test
        void isInRange_범위안인경우() {
            Assertions.assertThat(Validator.isInRange(List.of(1,2,3,4,5,6))).isTrue();
        }
    }

    @Nested
    class IsInRangeForInt {
        @DisplayName("주어진 숫자가 범위 밖에 있는 경우 False를 반환한다.")
        @Test
        void isInRange_범위밖인경우() {
            Assertions.assertThat(Validator.isInRange(140)).isFalse();

        }

        @DisplayName("주어진 숫자가 범위 내인 경우 True를 반환한다.")
        @Test
        void isInRange_범위안인경우() {
            Assertions.assertThat(Validator.isInRange(2)).isTrue();
        }
    }

    @Nested
    class IsDuplicateForOneArgument {
        @DisplayName("주어진 리스트에 중복이 없는 경우 False를 반환한다.")
        @Test
        void isDuplicate_중복없는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,6))).isFalse();
        }

        @DisplayName("주어진 리스트에 중복이 있는 경우 True를 반환한다.")
        @Test
        void isDuplicate_중복있는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,5))).isTrue();
        }
    }

    @Nested
    class IsDuplicateForTwoArguments {
        @DisplayName("주어진 리스트와 숫자가 중복되지 않는 경우 False를 반환한다.")
        @Test
        void isDuplicate_중복없는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,6), 7)).isFalse();
        }

        @DisplayName("주어진 리스트와 숫자가 중복되는 경우 True를 반환한다.")
        @Test
        void isDuplicate_중복있는경우() {
            Assertions.assertThat(Validator.isDuplicate(List.of(1,2,3,4,5,6), 1)).isTrue();
        }
    }

    @Nested
    class IsHundredUnit {
        @DisplayName("주어진 숫자가 1000원 단위인 경우 True를 반환한다.")
        @Test
        void isHundredTest_1000원단위() {
            Assertions.assertThat(Validator.isHundredUnit(12000)).isTrue();
        }

        @DisplayName("주어진 숫자가 1000원 단위가 아닌 경우 False를 반환한다.")
        @Test
        void isHundredTest_1000원단위아님() {
            Assertions.assertThat(Validator.isHundredUnit(123141)).isFalse();
        }
    }

    @Nested
    class IsPositive {
        @DisplayName("주어진 숫자가 0보다 큰 경우 True를 반환한다.")
        @Test
        void isHundredTest_양수() {
            Assertions.assertThat(Validator.isPositive(123141)).isTrue();
        }

        @DisplayName("주어진 숫자가 음수인 경우 False를 반환한다.")
        @Test
        void isHundredTest_음수() {
            Assertions.assertThat(Validator.isPositive(-123)).isFalse();
        }
    }
}
