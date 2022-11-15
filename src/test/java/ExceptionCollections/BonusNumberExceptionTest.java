package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberExceptionTest {
    @DisplayName("보너스 번호 중복 테스트")
    @Test
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(() ->
                BonusNumberException.validate(List.of(1, 2, 3, 4, 5, 6), "3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자 범위 테스트")
    @Test
    void 숫자_범위_테스트() {
        assertThatThrownBy(() ->
                BonusNumberException.validate(List.of(1, 2, 3, 4, 5, 47), "3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자 범위 테스트")
    @Test
    void 숫자_범위_테스트_2() {
        assertThatThrownBy(() ->
                BonusNumberException.validate(List.of(1, 2, 3, 4, 5, 0), "3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 빈 문자열 테스트")
    @Test
    void 빈_문자열_테스트() {
        assertThatThrownBy(() ->
                BonusNumberException.validate(List.of(1, 2, 3, 4, 5, 47), ""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
