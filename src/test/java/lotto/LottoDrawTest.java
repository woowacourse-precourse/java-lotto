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
            assertThat(method.invoke(lottoDraw, "1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("쉼표로 구분한 6개의 숫자가 아닌 경우 예외 발생")
    @Test
    void case2_split_comma() {
            assertThat(lottoDraw.pickWinNumbers("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
