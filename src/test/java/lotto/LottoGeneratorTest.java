package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("로또 구매 수량만큼 생성되는지 확인")
    @Test
    void case1() {
        int quantity = 4;
        List<Lotto> allLotto = LottoGenerator.getAllLotto(quantity);
        int size = 4;
        assertThat(allLotto.size()).isEqualTo(size);
    }
}

