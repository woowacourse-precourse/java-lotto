package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSummaryTest {

    @Test
    void 당첨_통계_테스트1() {
        //given
        List<Rank> ranks = List.of(FIFTH, FIFTH, FIFTH, FIFTH);
        Money money = new Money(4000);
        String expect = "3개 일치 (5,000원) - 4개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 500.0%입니다.";

        //when
        String summary = new LottoSummary(ranks, money).toString();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    void 당첨_통계_테스트2() {
        //given
        List<Rank> ranks = List.of(FIFTH, FIRST, SECOND, SECOND);
        Money money = new Money(4000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n" +
                "총 수익률은 51,500,125.0%입니다.";

        //when
        String summary = new LottoSummary(ranks, money).toString();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    void 당첨_통계_테스트3() {
        //given
        List<Rank> ranks = List.of(FIFTH, FOURTH, NOTHING, FOURTH);
        Money money = new Money(4000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 2개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 2,625.0%입니다.";

        //when
        String summary = new LottoSummary(ranks, money).toString();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    void 당첨_통계_테스트4() {
        //given
        List<Rank> ranks = List.of(FIFTH, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING);
        Money money = new Money(8000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 2개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.0%입니다.";

        //when
        String summary = new LottoSummary(ranks, money).toString();

        //then
        assertThat(summary).isEqualTo(expect);
    }
}