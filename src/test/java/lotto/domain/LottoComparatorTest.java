package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LottoComparatorTest {
    private LottoComparator lottoComparator;
    private Lotto lotto;
    private List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<List<Integer>> testNumbers = Arrays.asList(Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(7, 11, 16, 35, 36, 44));
        for (List<Integer> t : testNumbers) {
            lotto = new Lotto(t);
            lottos.add(lotto);
        }
        List<Integer> testWinningNumbers = List.of(8, 21, 23, 3, 5, 11);
        int testBonusNumber = 39;
        lottoComparator = new LottoComparator(lottos, testWinningNumbers, testBonusNumber);
    }


    @ParameterizedTest
    @DisplayName("등수별 당첨개수를 올바르게 세는지 테스트")
    @CsvSource({"3, false, 2", "4, false, 0", "5, false, 0", "5, true, 0", "6, false, 0"})
    void 당첨번호_비교결과_테스트(int numberMatchesCount, boolean includeBonus, int expected) {
        int result = lottoComparator.getNumberMatchesLottoNumber(numberMatchesCount, includeBonus);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("calculateMargin()메서드가 올바른 값을 반환하는지 테스트")
    @CsvSource({"150_000, 3_750.0", "30_000_000, 750_000.0", "1_550_000, 38_750.0", "5_000, 125.0"})
    void setUp_수익률_계산_테스트(int totalWinningAmount, double expected) {
        AtomicInteger calculateMarginArgument = new AtomicInteger(totalWinningAmount);
        double result = lottoComparator.calculateMargin(calculateMarginArgument);
        assertThat(result).isEqualTo(expected);
    }
}