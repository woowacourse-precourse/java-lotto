package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultJudgeTest {
    private static final LottoResultJudge lottoResultJudge = new LottoResultJudge();
    @DisplayName("구매한 로또 번호가 당첨 번호와 모두 일치하면 LottoResult.FIRST 를 리턴한다.")
    @Test
    void 일치하는_개수_1등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.FIRST);
    }

    @Test
    void 일치하는_개수_2등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,7);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.SECOND);
    }

    @Test
    void 일치하는_개수_3등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,8);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.THIRD);
    }

    @Test
    void 일치하는_개수_4등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,8,9);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.FOURTH);
    }

    @Test
    void 일치하는_개수_5등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,8,9,10);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.FIFTH);
    }

    @Test
    void 일치하는_개수_NOTHING() {
        List<Integer> userLotto = Arrays.asList(8,9,10,11,12,13);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lottoResultJudge.judgeLotto(userLotto, lotto, bonus)).isEqualTo(LottoResult.NOTHING);
    }
}
