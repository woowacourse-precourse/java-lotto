package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumbersExceptionTest {
    @DisplayName("숫자 개수 테스트")
    @Test
    void 숫자_개수_테스트() {
        assertThatThrownBy(() ->
                WinningNumbersExeption
                        .validate(List.of("1", "2", "3", "4", "5", "6", "7")))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 개수 테스트")
    @Test
    void 숫자_개수_테스트_2() {
        assertThatThrownBy(() ->
                WinningNumbersExeption
                        .validate(List.of("")))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자 포함 테스트")
    @Test
    void 문자_포함_테스트() {
        assertThatThrownBy(() ->
                WinningNumbersExeption
                        .validate(List.of("1", "a", "3", "4", "5", "6")))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위 테스트")
    @Test
    void 숫자_범위_테스트() {
        assertThatThrownBy(() ->
                WinningNumbersExeption
                        .validate(List.of("1", "0", "3", "4", "5", "6")))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자 포함 테스트")
    @Test
    void 중복_숫자_포함_테스트() {
        assertThatThrownBy(() ->
                WinningNumbersExeption
                        .validate(List.of("1", "1", "3", "4", "5", "6")))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}
