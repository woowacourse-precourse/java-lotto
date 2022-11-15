package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrizeLottoTest {
    @DisplayName("보너스 번호가 이미 당첨 번호에 있으면 예외.")
    @Test
    void duplicatedBonusNumberTest() {
        Assertions.assertThatThrownBy(() -> new PrizeLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
