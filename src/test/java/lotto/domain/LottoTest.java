package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @DisplayName("Lotto용지가 생성되는지 확인")
    @Test
    void when_createLotto_Expect_numbers() {
        List<Integer> numbers = List.of(1,32,35,29,10,8);
        Lotto lotto = new Lotto(numbers);
        assertThat(String.valueOf(lotto.getNumbers())).isEqualTo("[1, 32, 35, 29, 10, 8]");
    }
}
