package lotto.domain;

import lotto.ui.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("주어진 점수에 따라 정상적인 Result가 반환")
    @Test
    void getResultTest_정상점수() {
        Assertions.assertThat(Result.getResult(50)).isEqualTo(Result.FIVE);
    }

    @DisplayName("정상적이지 않은 점수로 인해 IllegalArgumentException 발생")
    @Test
    void getResultTest_비정상점수() {
        Assertions.assertThatThrownBy(
                        () -> Result.getResult(90)
                )
                .isInstanceOf(IllegalArgumentException.class);
    }
}
