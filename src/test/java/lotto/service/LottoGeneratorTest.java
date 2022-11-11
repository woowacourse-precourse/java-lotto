package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("로또 숫자 범위 확인 ")
    void generateNumsRangeTest() {
        List<Integer> randomNums = lottoGenerator.generateRandomNums();
        List<Integer> result = randomNums.stream()
            .filter(x -> x <= LOTTO_RANGE_END && LOTTO_RANGE_START <= x)
            .collect(Collectors.toList());
        assertThat(randomNums).containsAll(result);
    }

    @Test
    @DisplayName("로또 숫자 중복 확인 ")
    void generateNumsDistinctTest() {
        List<Integer> randomNums = lottoGenerator.generateRandomNums();
        List<Integer> result = randomNums.stream()
            .distinct().collect(Collectors.toList());
        assertThat(randomNums).containsAll(result);
    }

    @Test
    @DisplayName("로또 숫자 개수 확인 ")
    void generateNumsSizeTest() {
        List<Integer> randomNums = lottoGenerator.generateRandomNums();
        assertThat(randomNums.size()).isEqualTo(LOTTO_NUMS_SIZE);
    }
}