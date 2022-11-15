package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoExceptionTest {
    @DisplayName("번호 길이 테스트")
    @Test
    void 번호_길이_테스트() {
        assertThatThrownBy(() ->
                LottoException
                        .validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 정렬 테스트")
    @Test
    void 숫자_정렬_테스트() {
        assertThatThrownBy(() ->
                LottoException
                        .validate(List.of(7, 1, 2, 3, 4, 5)))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 정렬 테스트")
    @Test
    void 숫자_정렬_테스트_2() {
        assertThatThrownBy(() ->
                LottoException
                        .validate(List.of(1, 2, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 중복 테스트")
    @Test
    void 숫자_중복_테스트() {
        assertThatThrownBy(() ->
                LottoException
                        .validate(List.of(1, 2, 3, 4, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 밤으; 테스트")
    @Test
    void 숫자_범위_테스트() {
        assertThatThrownBy(() ->
                LottoException
                        .validate(List.of(1, 2, 3, 4, 6, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
