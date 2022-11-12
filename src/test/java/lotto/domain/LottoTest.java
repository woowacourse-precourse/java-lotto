package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class LottoTest {
    @Test
    @DisplayName("로또번호가 양식에 맞게 출력된다")
    void test1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}