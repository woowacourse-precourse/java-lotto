package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WinningResultTest {
    @Test
    void 구매한_모든_로또의_숫자_매칭_개수를_구한다() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(13, 14, 25, 37, 45, 2)),
                new Lotto(Arrays.asList(21, 45, 13, 2, 16, 19)),
                new Lotto(Arrays.asList(8, 41, 32, 39, 26, 6)),
                new Lotto(Arrays.asList(5, 18, 9, 43, 31, 27))
        ));

        List<Integer> winningNumbers = new ArrayList<>(
                Arrays.asList(4, 8, 13, 16, 28, 45));

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 2, 3, 1, 0));

        List<Integer> result = WinningResult.getMatchingCountOfAllLottos(lottos, winningNumbers);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 구매한_모든_로또의_보너스_번호_매칭_여부를_구한다() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(13, 14, 25, 37, 45, 2)),
                new Lotto(Arrays.asList(21, 45, 13, 2, 16, 19)),
                new Lotto(Arrays.asList(8, 41, 32, 39, 26, 6)),
                new Lotto(Arrays.asList(5, 18, 9, 43, 31, 27))
        ));

        int bonusNumber = 2;

        List<Boolean> expected = new ArrayList<>(
                Arrays.asList(true, true, true, false, false));

        List<Boolean> result = WinningResult.getBonusNumberMatchingOfAllLottos(lottos, bonusNumber);

        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {
            "1 : 4 : 15 : 34 : 23 : 45 : 3",
            "32 : 23 : 13 : 44 : 18 : 19 : 0",
            "31 : 27 : 5 : 6 : 43 : 24 : 1",
            "19 : 18 : 45 : 22 : 15 : 2 : 3",
            "43 : 41 : 38 : 36 : 25 : 13 : 0",
            "33 : 22 : 17 : 15 : 4 : 29 : 2"
    }, delimiter = ':')
    @ParameterizedTest
    void 당첨_번호와_일치하는_숫자의_개수를_구한다(int one, int two, int three, int four, int five, int six, int expected) {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(
                one, two, three, four, five, six
        ));

        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(45, 31, 1, 3, 22, 15));

        int result = WinningResult.getEachLottoMatchingCount(lotto, winningNumbers);

        assertThat(result).isEqualTo(expected);
    }
}