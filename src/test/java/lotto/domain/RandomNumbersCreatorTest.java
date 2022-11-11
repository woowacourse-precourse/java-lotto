package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersCreatorTest {

    @DisplayName("주어진 범위 안에 6개의 랜덤 로또 번호를 만드는 기능")
    @RepeatedTest(50)
    void createLottoNumberInRange() {
        List<Integer> lottoNumbers = RandomLottoNumberCreator.createLottoNumber();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (int number : lottoNumbers) {
            assertThat(number >= 1 && number <= 45).isTrue();
        }
    }

    @DisplayName("주어진 범위 안에서 주어진 개수 만큼 6개의 랜덤 로또 번호들을 만드는 기능")
    @Test
    void createLottoNumbersInRange() {
        List<List<Integer>> lottoNumbers = RandomLottoNumberCreator.createLottoNumber(4);
        assertThat(lottoNumbers.size()).isEqualTo(4);
    }
}
