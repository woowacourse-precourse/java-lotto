package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ScopeOverExceptionTest {
    @Test
    void ScopeCheckTest() {
        assertThat(ScopeOverException.scopeCheck(1)).isEqualTo(1);
        assertThat(ScopeOverException.scopeCheck(46));
    }// ScopeCheckTest
}// end class
