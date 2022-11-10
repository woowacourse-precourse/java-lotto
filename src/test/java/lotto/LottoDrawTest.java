package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.LottoDraw;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawTest {

    LottoDraw lottoDraw = LottoDraw.getInstance();

    @DisplayName("쉼표로 구분한 요소가 6개가 아닌 경우 예외 발생")
    @Test
    void case1_split_comma() {
        try {
            String input = "1,2,3,4,5";
            Class<IllegalArgumentException> result = IllegalArgumentException.class;
            Method method = LottoDraw.class.getDeclaredMethod("validateComma", String.class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoDraw, input)).isInstanceOf(result);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("쉼표로 구분한 요소가 숫자가 아닌 경우 예외 발생")
    @Test
    void case2_validate_numeric() {
        try {
            String[] input = "1,2,3,4,5,j".split(",");
            Class<IllegalArgumentException> result = IllegalArgumentException.class;
            Method method = LottoDraw.class.getDeclaredMethod("validateNumeric", String[].class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoDraw, (Object) input)).isInstanceOf(result);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("6개의 숫자에 중복이 있는 경우 예외 발생")
    @Test
    void case3_duplication_in_numbers() {
        try {
            List<Integer> input = List.of(1, 2, 3, 4, 5, 5);
            Class<IllegalArgumentException> result = IllegalArgumentException.class;
            Method method = LottoDraw.class.getDeclaredMethod("validateDuplication", List.class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoDraw, input)).isInstanceOf(result);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("1~45 까지의 범위를 벗어난 숫자가 있는 경우 예외 발생")
    @Test
    void case4_validate_range() {
        try {
            List<Integer> input = List.of(1, 2, 3, 4, 5, 46);
            Class<IllegalArgumentException> result = IllegalArgumentException.class;
            Method method = LottoDraw.class.getDeclaredMethod("validateRange", List.class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoDraw, input)).isInstanceOf(result);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("쉼표로 구분한 중복이 없는 6개의 숫자가 맞는 경우 리스트 반환")
    @Test
    void case5_correct_data_result() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lottoDraw.pickWinNumbers(input)).isEqualTo(result);
    }
}
