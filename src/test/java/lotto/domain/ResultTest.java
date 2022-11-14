package lotto.domain;

import lotto.domain.lotto.correctLotto.Ranking;
import lotto.domain.lotto.correctLotto.Rankings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class ResultTest {
    @Test
    void 수익_테스트() throws Exception {
        //given
        Money money = new Money(8000);
        money.paid(1000, 8);
        Ranking fifthRanking = Ranking.FIFTHRANKING;
        Ranking fourthRanking = Ranking.FOURTHRANKING;

        //when
        Result result = new Result(new Rankings(List.of(fifthRanking, fourthRanking)), money);

        //then
        Assertions.assertThat(result.getRevenue())
                .isEqualTo(55000);

    }

    @Test
    void 수익률_테스트() throws Exception {
        //given
        Money money = new Money(8000);
        money.paid(1000, 8);
        Ranking fifthRanking = Ranking.FIFTHRANKING;

        //when
        Result result = new Result(new Rankings(List.of(fifthRanking)), money);

        //then
        Assertions.assertThat(result.getYield())
                .isEqualTo(62.5);
    }

}