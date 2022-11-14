package lotto.ExceptionChecker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyInputCheckerTest {

    @DisplayName("1000원 단위로 주지않으면 예외가 발생한다.")
    @Test
    void createNotThousandUnitMoneyInput() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new MoneyInputChecker(14001))
                .isInstanceOf(NoSuchElementException.class);
    }


}