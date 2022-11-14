package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRuleTest {

    @Test
    public void 로또범위_정상() {
        assertThatCode(() -> LottoRule.validateRange(32)).doesNotThrowAnyException();
    }

    @Test
    public void 로또범위_벗어남() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> LottoRule.validateRange(-32));
        assertThat(exception.getMessage()).contains("로또 번호의 범위를 넘어갔습니다.");
    }

    @Test
    public void 로또사이즈_정상() {
        assertThatCode(() -> LottoRule.validateSize(6)).doesNotThrowAnyException();
    }

    @Test
    public void 로또사이즈_비정상() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> LottoRule.validateSize(-32));
        assertThat(exception.getMessage()).contains("6개의 값을 입력");
    }

}