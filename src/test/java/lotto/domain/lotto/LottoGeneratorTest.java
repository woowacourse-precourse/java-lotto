package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("발행하는 로또의 숫자는 6개여야 한다.")
    @Test
    void getLottoCount() {
        List<Integer> lotto = LottoGenerator.createRandomLottoNumber();

        int randomLottoSize = lotto.size();

        assertThat(randomLottoSize).isEqualTo(6);
    }

    @DisplayName("발행하는 로또에는 중복된 숫자가 있으면 안된다.")
    @Test
    void getDuplicateLottoCount() {
        List<Integer> lotto = LottoGenerator.createRandomLottoNumber();

        long notDuplicateCount = lotto.stream()
                .distinct()
                .count();

        assertThat(notDuplicateCount).isEqualTo(6);
    }

    @DisplayName("발행하는 로또의 각 수는 1 - 45 범위를 벗어나지 않는다.")
    @Test
    void getLottoRange() {
        List<Integer> lotto = LottoGenerator.createRandomLottoNumber();

        long zeroCount = lotto.stream()
                .filter(n -> n <= 0 || n > 45)
                .count();

        assertThat(zeroCount).isEqualTo(0);
    }
}

