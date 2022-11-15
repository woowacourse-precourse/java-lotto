package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("생성된 로또 번호가 오름차순으로 정렬되었는지 테스트")
    @Test
    void createLottoWithSortedRandomNumbers() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.createLottoNumbers();
        List<Integer> sortedNumbers = lottoNumbers.stream().sorted()
                .collect(Collectors.toList());
        assertThat(lottoNumbers).isEqualTo(sortedNumbers);
    }
}