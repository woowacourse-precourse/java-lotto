package lotto.ExceptionChecker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerCheckerTest {

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void createNotInteger() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new IntegerChecker("t1"))
                .isInstanceOf(NoSuchElementException.class);
    }

}