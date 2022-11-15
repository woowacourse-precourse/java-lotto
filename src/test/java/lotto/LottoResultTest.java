package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("수익금을 반환한다.")
    @Test
    void getReward() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.putRank(Rank.FIRST);
        lottoResult.putRank(Rank.SECOND);
        Long reward = Rank.FIRST.prize(1) + Rank.SECOND.prize(1);
        assertThat(lottoResult.getReward().equals(reward)).isTrue();
    }
}
