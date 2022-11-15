package lotto.domian;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 생성시 로또는 6개의 수로 이루어진다.")
    @Test
    void createLottoFromLottoGenerator() {
        // given
        List<Integer> lotto = lottoGenerator.createLotto();

        // then
        assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호가 1과 45로 사이의 수로 구성된다.")
    @Test
    void createLottoFromLottoGeneratorConsistOf1To45() {
        // given
        List<Integer> lotto = lottoGenerator.createLotto();

        // when
        List<Integer> validLotto = lotto.stream().filter(num -> 1 <= num && num <= 45)
            .collect(Collectors.toList());

        // then
        assertThat(validLotto.size()).isEqualTo(6);
    }
}