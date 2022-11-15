package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LottosTest {
    final int LOTTO_START_ONE = 1;
    final int LOTTO_END_SEVEN = 7;
    final int REVERSE_LOTTO_START_SIX = 6;
    final int REVERSE_LOTTO_END_ZERO = 0;
    final int LINE_COUNT = 3;
    final int FALSE_LINE_COUNT = 4;

    @Test
    void 로또_라인_수_확인() throws Exception {
        int lineCount = 3;

        //given
        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SEVEN; i++) {
            temp.add(i);
        }

        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            lottosTemp.add(new Lotto(temp));
        }

        Lottos lottos = new Lottos(lottosTemp);

        //when
        int lottoLines = lottos.getSizeOfLottoLines();

        //then
        Assertions.assertThat(lottoLines)
                .isEqualTo(lineCount);
    }

    @Test
    void 로또_라인_수_확인_예외() throws Exception {

        //given
        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SEVEN; i++) {
            temp.add(i);
        }

        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < LINE_COUNT; i++) {
            lottosTemp.add(new Lotto(temp));
        }

        Lottos lottos = new Lottos(lottosTemp);

        //when
        int lottoLines = lottos.getSizeOfLottoLines();

        //then
        Assertions.assertThat(lottoLines)
                .isNotEqualTo(FALSE_LINE_COUNT);
    }

    @Test
    void 로또_라인_값보기() throws Exception {
        //given
        List<Integer> reverseTemp = new ArrayList<>();
        for (int i = REVERSE_LOTTO_START_SIX; i > REVERSE_LOTTO_END_ZERO; i--) {
            reverseTemp.add(i);
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = LOTTO_START_ONE; i < LOTTO_END_SEVEN; i++) {
            temp.add(i);
        }

        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < LINE_COUNT; i++) {
            lottosTemp.add(new Lotto(reverseTemp));
        }
        Lottos lottos = new Lottos(lottosTemp);

        //when
        List<List<Integer>> lottoDetails = new ArrayList<>();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> sortedDetails = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedDetails);
            lottoDetails.add(sortedDetails);
        }

        //then
        Assertions.assertThat(lottoDetails)
                .containsExactly(temp, temp, temp);
    }
}