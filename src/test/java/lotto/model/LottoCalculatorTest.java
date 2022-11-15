package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCalculatorTest {
    private LottoCalculator lottoCalculator;


    @BeforeEach
    void setup() {
        this.lottoCalculator = new LottoCalculator();
    }

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void lottoNumberDuplicated() {
        final int lottoCount = 6;
        final int startNumber = 1;
        final int endNumber = 45;


        List<Integer> actual = this.lottoCalculator.createLotto();
        assertThat(actual).doesNotHaveDuplicates().hasSize(lottoCount);

        for (Integer number : actual) {
            assertThat(number.intValue()).isBetween(startNumber, endNumber);
        }
    }

    @DisplayName("로또 번호가 정렬 하는지 확인")
    @Test
    void lottoNumbersIsSorted() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Lotto> lottos = new ArrayList<>(1);
        lottos.add(lotto);
        ArrayList<ArrayList<Integer>> result = this.lottoCalculator.getDisplayLottoNumbers(lottos);

        ArrayList<Integer> actual = result.get(0);
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expected = expectedLotto.getNumbers();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("랭킹 개수를 제대로 반환하는지 테스트")
    @Test
    void lottoRankingsCorrect() {
        final int lottoCount = 10;
        final int rankingTypeCount = 6;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = 7;

        List<Lotto> lottos = new ArrayList<>(lottoCount);
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        Map<LottoRankingType, Integer> actual
                = this.lottoCalculator.getRankings(winningNumbers, bonusNumber, lottos);

        Map<LottoRankingType, Integer> expected = new HashMap<>(rankingTypeCount);
        expected.put(LottoRankingType.FIRST_PLACE, 1);
        expected.put(LottoRankingType.SECOND_PLACE, 1);
        expected.put(LottoRankingType.THIRD_PLACE, 1);
        expected.put(LottoRankingType.FOURTH_PLACE, 1);
        expected.put(LottoRankingType.FIFTH_PLACE, 1);
        expected.put(LottoRankingType.BANG, 0);

        assertThat(actual).isEqualTo(expected);
    }

}