package lotto.model;

import lotto.model.Issue.LottoIssue;
import lotto.model.Issue.LottoIssueImpl;
import lotto.model.statistics.Matcher;
import lotto.model.statistics.MatcherImpl;
import lotto.model.statistics.Rank;
import lotto.model.statistics.Statistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatcherTest {

    @Test
    @DisplayName("매치 계산 성공")
    void case1(){
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,7));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6),7);

        //when
        Matcher matcher = new MatcherImpl(lottoList,winningNumbers, BigDecimal.valueOf(2000));
        Statistics result = matcher.getStatistics();
        Map<Rank, BigDecimal> rankCount = result.getRankCount();
        BigDecimal prize = result.getPrize();
        BigDecimal yield = result.getYield();

        //then
        Assertions.assertThat(prize).isEqualTo(BigDecimal.valueOf(2_030_000_000));
        Assertions.assertThat(yield).isEqualTo(BigDecimal.valueOf(101_500_000.0).setScale(1,RoundingMode.HALF_UP));
        Assertions.assertThat(rankCount.get(Rank.FIRST)).isEqualTo(BigDecimal.ONE);
        Assertions.assertThat(rankCount.get(Rank.SECOND)).isEqualTo(BigDecimal.ONE);
        Assertions.assertThat(rankCount.get(Rank.THIRD)).isEqualTo(BigDecimal.ZERO);
        Assertions.assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(BigDecimal.ZERO);
        Assertions.assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(BigDecimal.ZERO);

    }
}
