package Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CreateLottoTest {

    @DisplayName("8000원 입력, 로또 8장 발행")
    @Test
    void checkRandomLottoSize(){
        List<List<Integer>> randomLottoNumbers = CreateRandomLotto.createRandomLottoNumber(8000);

        int numberOfLotto = randomLottoNumbers.size();
        int result = 8;

        Assertions.assertThat(numberOfLotto).isEqualTo(result);
    }

}