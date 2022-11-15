package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultJudgeTest {
    private LottoResultJudge lottoResultJudge;
    @BeforeEach
    void setUp() {
        lottoResultJudge = new LottoResultJudge();
        Stream.of(LottoResult.values()).forEach(lottoResult -> lottoResult.init());
    }

    @DisplayName("구매한 로또 번호가 1등이라면 LottoResult.FIRST 의 카운트를 +1 한다.")
    @Test
    void 일치하는_개수_1등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        lottoResultJudge.judgeLotto(userLotto, lotto, bonus);
        assertThat(LottoResult.FIRST.getCount()).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호가 2등이라면 LottoResult.SECOND 의 카운트를 +1 한다.")
    @Test
    void 일치하는_개수_2등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,7);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        lottoResultJudge.judgeLotto(userLotto, lotto, bonus);
        assertThat(LottoResult.SECOND.getCount()).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호가 3등이라면 LottoResult.THIRD 의 카운트를 +1 한다.")
    @Test
    void 일치하는_개수_3등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,8);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        lottoResultJudge.judgeLotto(userLotto, lotto, bonus);
        assertThat(LottoResult.THIRD.getCount()).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호가 4등이라면 LottoResult.FOURTH 의 카운트를 +1 한다.")
    @Test
    void 일치하는_개수_4등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,8,9);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        lottoResultJudge.judgeLotto(userLotto, lotto, bonus);
        assertThat(LottoResult.FOURTH.getCount()).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호가 5등이라면 LottoResult.FIFTH 의 카운트를 +1 한다.")
    @Test
    void 일치하는_개수_5등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,8,9,10);
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        int bonus = 7;
        lottoResultJudge.judgeLotto(userLotto, lotto, bonus);
        assertThat(LottoResult.FIFTH.getCount()).isEqualTo(1);
    }
}
