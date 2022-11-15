package lotto.domain;


import lotto.domain.lotto.correctLotto.CorrectLottoNumbers;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.correctLotto.Ranking;
import lotto.domain.lotto.correctLotto.RankingValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CorrectLottoNumbersTest {
    final int LOTTO_START_ONE = 1;
    final int LOTTO_END_SEVEN = 7;
    final int LOTTO_END_SIX = 6;
    final int LOTTO_START_ELEVEN = 11;
    final int LOTTO_END_SEVENTEEN = 17;
    final int CORRECT_NUMBER_END_EIGHT = 8;
    final int BONUS_NUMBER_SEVEN = 7;

    @Test
    void 당첨번호_비교_일등() throws Exception {
        //given
        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SEVEN; i++) {
            temp.add(i);
        }

        List<LottoNumber> correctTemp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < CORRECT_NUMBER_END_EIGHT; i++) {
            correctTemp.add(new LottoNumber(i));
        }
        //when
        Lotto lotto = new Lotto(temp);
        CorrectLottoNumbers correctLottoNumbers = new CorrectLottoNumbers(correctTemp);
        Ranking ranking = correctLottoNumbers.compareLottoNumber(lotto);

        //then
        Assertions.assertThat(ranking.getRankingValue())
                .isEqualTo(RankingValue.FIRST);
    }

    @Test
    void 당첨번호_비교_이등() throws Exception {
        //given
        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SIX; i++) {
            temp.add(i);
        }
        temp.add(BONUS_NUMBER_SEVEN);

        List<LottoNumber> correctTemp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < CORRECT_NUMBER_END_EIGHT; i++) {
            correctTemp.add(new LottoNumber(i));
        }

        //when
        Lotto lotto = new Lotto(temp);
        CorrectLottoNumbers correctLottoNumbers = new CorrectLottoNumbers(correctTemp);
        Ranking ranking = correctLottoNumbers.compareLottoNumber(lotto);

        //then
        Assertions.assertThat(ranking.getRankingValue())
                .isEqualTo(RankingValue.SECOND);

    }

    @Test
    void 당첨번호_비교_등외() throws Exception {
        //given
        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ELEVEN; i < LOTTO_END_SEVENTEEN; i++) {
            temp.add(i);
        }

        List<LottoNumber> correctTemp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < CORRECT_NUMBER_END_EIGHT; i++) {
            correctTemp.add(new LottoNumber(i));
        }

        //when
        Lotto lotto = new Lotto(temp);
        CorrectLottoNumbers correctLottoNumbers = new CorrectLottoNumbers(correctTemp);
        Ranking ranking = correctLottoNumbers.compareLottoNumber(lotto);

        //then
        Assertions.assertThat(ranking.getRankingValue())
                .isEqualTo(RankingValue.OUT);
    }
}