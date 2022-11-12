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
}
