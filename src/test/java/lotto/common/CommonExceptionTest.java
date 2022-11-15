package lotto.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public abstract class CommonExceptionTest {

    public void assertIllegalArgumentExceptionWithMessage(ThrowingCallable shouldRaiseThrowable, String message) {
        assertThatThrownBy(shouldRaiseThrowable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}
