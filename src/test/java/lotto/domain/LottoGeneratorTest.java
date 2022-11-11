package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {

    @DisplayName("발행하는 로또의 숫자는 6개여야 한다.")
    @Test
    void 로또_개수() {
        List<Integer> lotto = LottoGenerator.createRandomLottoNumber();
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("발행하는 로또에는 중복된 숫자가 있으면 안된다.")
    @Test
    void 로또_중복() {
        List<Integer> lotto = LottoGenerator.createRandomLottoNumber();
        Assertions.assertThat(lotto.stream().distinct().count()).isEqualTo(6);
    }
}

