package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("복권번호 생성")
    @Test
    void createLottoNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<List<Integer>> lottoNumber = numberGenerator.createRandomNumbers(2);
        assertThat(lottoNumber).isNotEmpty();
    }

    @DisplayName("생성된 로또번호 사이즈 확인")
    @Test
    void checkCreateLottoNumberSize() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<List<Integer>> lottoNumber = numberGenerator.createRandomNumbers(2);
        assertThat(lottoNumber.size()).isEqualTo(2);
    }
}