package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoResultSummaryTest {

    @Test
    @DisplayName("5등 - 4번")
    void 당첨_통계_테스트1() {
        //given
        List<Rank> ranks = List.of(FIFTH, FIFTH, FIFTH, FIFTH);
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 4개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 500.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    @DisplayName("5등 - 1번, 2둥 - 2번, 1등 - 1번")
    void 당첨_통계_테스트2() {
        //given
        List<Rank> ranks = List.of(FIFTH, FIRST, SECOND, SECOND);
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n" +
                "총 수익률은 51,500,125.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    @DisplayName("5등 - 1번, 4둥 - 2번")
    void 당첨_통계_테스트3() {
        //given
        List<Rank> ranks = List.of(FIFTH, FOURTH, NOTHING, FOURTH);
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 2개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 2,625.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    @DisplayName("5등 - 1번")
    void 당첨_통계_테스트4() {
        //given
        List<Rank> ranks = List.of(FIFTH, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING);
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    @DisplayName("당첨 없는 경우")
    void 당첨_통계_테스트5() {
        //given
        List<Rank> ranks = List.of(NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING, NOTHING);
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 0.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    @DisplayName("구입 금액 최대값 테스트")
    void 당첨_통계_테스트6() {
        //given
        List<Rank> ranks = Stream.generate(() -> FIRST)
                .limit(Integer.MAX_VALUE / 1000)
                .collect(Collectors.toList());
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 2147483개\n" +
                "총 수익률은 200,000,000.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }

    @Test
    void 구매_금액이_0원인_경우_수익률은_0으로_계산한다() {
        //given
        List<Rank> ranks = List.of();
        Money money = new Money(ranks.size() * 1000);
        String expect = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 0.0%입니다.";

        //when
        String summary = new LottoResultSummary(ranks, money).summaryLottoResult();

        //then
        assertThat(summary).isEqualTo(expect);
    }
}