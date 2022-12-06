package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "20000:20", "3000000:3000"}, delimiter = ':')
    void checkNumberOfIssuedLotto(int input, int size) {
        PurchaseAmount.validate(input);
        List<List<Integer>> myLotto = LottoGenerator.generateLotto();
        assertThat(myLotto.size()).isEqualTo(size);
    }
}
