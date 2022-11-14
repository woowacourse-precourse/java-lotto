package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersGeneratorTest {
    LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

    @DisplayName("생성된 Integer 리스트에 중복이 없다.")
    @Test
    void getLottoNumbersNotDuplicate() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.getLottoNumbers();

        HashSet set = new HashSet<>();
        for (Integer lottoNumber : lottoNumbers) {
            set.add(lottoNumber);
        }
        assertThat(set.size()).isEqualTo(6);
    }

    @DisplayName("생성된 Integer 리스트의 사이즈가 6이다.")
    @Test
    void getLottoNumbersProperSize() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.getLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성된 Integer 리스트가 오름차순 정렬되어 있다.")
    @Test
    void getLottoNumbersOrdered() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.getLottoNumbers();

        int tmp = 0;
        for (Integer number : lottoNumbers) {
            if (tmp > number) {
                Assertions.assertTrue(false);
            }
            tmp = number;
        }
    }
}
