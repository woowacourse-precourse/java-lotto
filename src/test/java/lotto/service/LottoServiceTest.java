package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("발행된 로또 숫자의 범위를 확인 한다.")
    void generateNumsRangeTest() {
        Lotto lotto = lottoService.issueLotto();
        List<Integer> result = lotto.getNumbers().stream()
                .filter(x -> x <= LOTTO_RANGE_END && LOTTO_RANGE_START <= x)
                .collect(Collectors.toList());
        assertThat(result).containsAll(lotto.getNumbers());
    }

    @Test
    @DisplayName("발행된 로또 숫자의 중복을 확인한다. ")
    void generateNumsDistinctTest() {
        Lotto lotto = lottoService.issueLotto();
        List<Integer> result = lotto.getNumbers().stream()
                .distinct().collect(Collectors.toList());
        assertThat(result).containsAll(lotto.getNumbers());
    }

    @Test
    @DisplayName("발행된 로또 숫자의 개수를 확인한다. ")
    void generateNumsSizeTest() {
        Lotto lotto = lottoService.issueLotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_NUMS_SIZE);
    }
}