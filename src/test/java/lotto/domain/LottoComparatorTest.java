package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @CsvSource({"3,false, 2", "4,false, 0", "5,false, 0", "5,true, 0", "6, false, 0"})
        //2개 0개 0개 0개 0개
    void 당첨번호_비교결과_테스트(int numberMatchesCount, boolean includeBonus, int expected) {
        int result = lottoComparator.getNumberMatchesLottoNumber(numberMatchesCount, includeBonus);
        assertThat(result).isEqualTo(expected);
    }
}