package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("주어진 점수에 따른 정상적인 Result를 반환한다.")
    @Test
    void getResultTest_정상점수() {
        Assertions.assertThat(Result.computeScore(50)).isEqualTo(Result.FIVE);
    }

    @DisplayName("정상적이지 않은 점수인 경우 NOTHING을 반환한다.")
    @Test
    void getResultTest_비정상점수() {
        Assertions.assertThat(Result.computeScore(90)).isEqualTo(Result.NOTING);
    }
}
