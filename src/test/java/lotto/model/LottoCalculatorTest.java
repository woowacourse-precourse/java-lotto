package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCalculatorTest {

    @DisplayName("로또 번호가 정렬 하는지 확인")
    @Test
    void lottoNumbersIsSorted() {
        LottoCalculator lottoCalculator = new LottoCalculator();
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Lotto> lottos = new ArrayList<>(1);
        lottos.add(lotto);
        ArrayList<ArrayList<Integer>> result = lottoCalculator.getDisplayLottoNumbers(lottos);

        ArrayList<Integer> actual = result.get(0);
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expected = expectedLotto.getNumbers();

        assertThat(actual).isEqualTo(expected);
    }
}