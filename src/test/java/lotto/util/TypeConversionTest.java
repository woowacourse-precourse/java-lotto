package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeConversionTest {

    @DisplayName("입력값에 숫자만 있는지 확인 - 숫자만 존재하지 않음")
    @Test
    void stringToIntNotOnlyNumber() {
        // given
        String input = "8000j";

        // expected
        assertThatThrownBy(() -> TypeConversion.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 숫자만 있는지 확인 - 숫자만 존재함")
    @Test
    void stringToIntOnlyNumber() {
        // given
        String input = "8000";

        // expected
        TypeConversion.stringToInt(input);
    }

    @DisplayName("문자열을 쉼표로 구분할 수 있는지 확인 - 구분 가능")
    @Test
    void stringListToIntList() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> result = TypeConversion.stringToIntList(input);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("문자열을 쉼표로 구분할 수 있는지 확인 - 구분 불가능")
    @Test
    void stringListToIntList2() {
        // given
        String input = "1,2,3,4,5, 6";

        // expected
        assertThatThrownBy(() -> TypeConversion.stringToIntList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}