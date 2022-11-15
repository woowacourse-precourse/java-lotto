package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.service.LottoGrade;
import lotto.service.LottoWinningGradeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningGradeCalculatorTest {

    private LottoWinningGradeCalculator lottoWinningGradeCalculator = new LottoWinningGradeCalculator();

    @Test
    @DisplayName("로또 등수를 판별한다")
    void getLottoWinningGrade() {
        assertEquals(lottoWinningGradeCalculator.getLottoGrade(Arrays.asList(1, 2, 3, 4, 5, 6),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))), LottoGrade.FIRST);
    }
}
