package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumbersTest {

    @DisplayName("설정된 개수만 큼 로또 번호를 생성한다.")
    @Test
    void generateNumbersLimitsCount() {
        // given
        Numbers numbers = new RandomNumbers();

        // when
        List<Integer> generatedNumbers = numbers.generate();

        // then
        assertThat(generatedNumbers.size()).isEqualTo(Config.LOTTO_NUMBER_COUNT);
    }

    @DisplayName("중복 없이 로또 번호를 생성한다.")
    @Test
    void generateNumbersWithoutDuplicate() {
        // given
        Numbers numbers = new RandomNumbers();

        // when
        List<Integer> generatedNumbers = numbers.generate();

        // then
        assertThat(generatedNumbers).doesNotHaveDuplicates();
    }
}
