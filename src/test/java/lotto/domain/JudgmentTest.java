package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class JudgmentTest {
    private Judgment judgment;
    
    @BeforeEach
    void setUp() {
        judgment = new Judgment();
    }
    
    @DisplayName(",의 개수가 4개이면 예외가 발생한다.")
    @Test
    void check5Commas() {
        assertThatThrownBy(() -> judgment.check5Commas("1,2,3,4,5"))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
