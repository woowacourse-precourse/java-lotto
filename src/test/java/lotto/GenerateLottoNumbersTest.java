package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domian.UserSingleLottoNumber;
import lotto.util.GenerateLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GenerateLottoNumbersTest {

    GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();

    @DisplayName("generateLottoNumber 메서드 테스트")
    @Test
    void generateLottoNumberTest() {
        // given
        int lottoQuantity = 1;
        int numberOfLotto = 6;

        // when
        List<UserSingleLottoNumber> lotto = generateLottoNumbers.generateLottoNumber(lottoQuantity);

        // then
        assertThat(lotto.size()).isEqualTo(lottoQuantity);
        assertThat(lotto.get(0).getLottoNumbers().size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("listSort 메서드 테스트")
    @Test
    void listSortTest() {
        // given
        List<Integer> unsortedList = List.of(1, 6, 5, 2, 3, 4);
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> sortedList = generateLottoNumbers.listSort(unsortedList);

        // then
        assertThat(sortedList).isEqualTo(list);
    }
}
