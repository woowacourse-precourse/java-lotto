package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또를 제대로 만드는지 확인")
    void createRandomNumberTest() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        assertRandomUniqueNumbersInRangeTest(() -> {
            assertThat(lottoNumberGenerator.createRandomNumbers(1).get(0)).isEqualTo(List.of(1,2,3,4,5,6));

        }, List.of(1, 2, 3, 4, 5, 6));

    }


}
