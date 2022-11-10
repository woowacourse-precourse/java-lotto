package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.LottoDraw;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawTest {

    LottoDraw lottoDraw = LottoDraw.getInstance();

    @DisplayName("쉼표로 구분한 6개의 숫자가 아닌 경우 예외 발생")
    @Test
    void case1_split_comma() {
        try {
            Method method = LottoDraw.class.getDeclaredMethod("validateComma", String.class);
            method.setAccessible(true);
            assertThat(method.invoke(lottoDraw, "1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("6개의 숫자에 중복이 있는 경우 예외 발생")
    @Test
    void case2_duplication_in_numbers() {
        try {
            Method method = LottoDraw.class.getDeclaredMethod("validateDuplication", List.class);
            method.setAccessible(true);
            assertThat(method.invoke(lottoDraw, List.of(1,2,3,4,5,5)))
                    .isInstanceOf(IllegalArgumentException.class);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("쉼표로 구분한 중복이 없는 6개의 숫자가 맞는 경우 리스트 반환")
    @Test
    void case3_correct_data_result() {
            assertThat(lottoDraw.pickWinNumbers("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
