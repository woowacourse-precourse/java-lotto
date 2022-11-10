package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersCreatorTest {

    @DisplayName("주어진 범위 안에 6개의 랜덤 로또 번호를 만드는 기능")
    @RepeatedTest(50)
    void createLottoNumberInRange() {
        List<Integer> lottoNumbers = RandomNLottoNumberCreator.createLottoNumber();
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for (int number : lottoNumbers) {
            assertThat(number >= 1 && number <= 45).isTrue();
        }
    }

}
