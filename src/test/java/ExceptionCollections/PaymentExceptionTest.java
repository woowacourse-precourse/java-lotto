package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PaymentExceptionTest {
    @DisplayName("빈 문자열 테스트")
    @Test
    void 빈_문자열_테스트() {
        assertThatThrownBy(() ->
                PaymentException
                        .validate(""))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자 포함 테스트")
    @Test
    void 문자_포함_테스트() {
        assertThatThrownBy(() ->
                PaymentException
                        .validate("800a"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 단위 테스트")
    @Test
    void 돈_단위_테스트() {
        assertThatThrownBy(() ->
                PaymentException
                        .validate("8001"))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}
