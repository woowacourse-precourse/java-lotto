package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ValidatorTest {

    @DisplayName("1000으로 나누어 떨어지는 값 입력 시 정상 동작")
    @Test
    void test1() {
        //Given
        int cost = 3000;

        //When
        Throwable t = catchThrowable(() -> validateForDividedBy1000(cost));

        //Then
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 값 입력 시 에러 발생")
    @Test
    void test2() {
        //Given
        int cost = 3500;

        //When
        Throwable t = catchThrowable(() -> validateForDividedBy1000(cost));

        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력해야합니다.");
    }

    @DisplayName("숫자로 구성되어 있는 정상적인 입력")
    @Test
    void test3() {
        //Given
        String input = "15000";

        //When
        Throwable t = catchThrowable(() -> validateForIllegalInput(input));

        //Then
        assertThat(t)
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자가 아닌 값을 입력할 경우")
    @Test
    void test4() {
        //Given
        String input = "l5000";

        //When
        Throwable t = catchThrowable(() -> validateForIllegalInput(input));

        //Then
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.");
    }

    private void validateForIllegalInput(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
    }

    private void validateForDividedBy1000(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다.");
        }
    }
}
