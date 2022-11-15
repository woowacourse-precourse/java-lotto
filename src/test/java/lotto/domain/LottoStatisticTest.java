package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
    @DisplayName("2등 당첨 개수 확인")
    @Test
    void summarizeRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoBundle lottoBundle =new LottoBundle(5);
                    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    LottoStatistic lottoStatistic = new LottoStatistic(
                            lottoBundle,7,lotto,5000);
                    assertThat(lottoStatistic.summarizeRank(Rank.Second_Place)).contains(
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 44, 45),
                List.of(1, 2, 3, 43, 44, 45)
        );
    }
    @DisplayName("LottoStatistic 출력 확인")
    @Test
    void createLottoListTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoBundle lottoBundle =new LottoBundle(5);
                    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    LottoStatistic lottoStatistic = new LottoStatistic(
                            lottoBundle,7,lotto,5000);
                    double profitRate = (5000+50000+1500000+30000000+2000000000)/5000;
                    assertThat(lottoStatistic.toString()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 "+String.format("%.1f", profitRate*100)+"%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 44, 45),
                List.of(1, 2, 3, 43, 44, 45)
        );
    }
    @DisplayName("당첨 로또 비교")
    @ParameterizedTest
    @MethodSource("generateData")
    void compareWin_lottoTest(List<Integer> list1, List<Integer> list2,int count) {

        LottoBundle lottoBundle =new LottoBundle(5);
        Lotto lotto = new Lotto(list1);
        LottoStatistic lottoStatistic = new LottoStatistic(
                lottoBundle,7,lotto,5000);
        assertThat(lottoStatistic.compareWin_lotto(new Lotto(list2))).isEqualTo(count);
    }
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of( List.of(1, 2, 3, 4, 5, 6),List.of(1, 2, 3, 4, 5, 6),6),
                Arguments.of( List.of(1, 2, 3, 4, 5, 6),List.of(1, 2, 3, 4, 5, 45),5),
                Arguments.of( List.of(8, 21, 23, 41, 42, 43),List.of(1, 2, 3, 8, 42, 45),2),
                Arguments.of( List.of(1, 2, 3, 4, 5, 6),List.of(45, 44, 43, 42, 41, 40),0),
                Arguments.of( List.of(13, 14, 16, 38, 42, 45),List.of(1, 2, 3, 4, 45, 7),1)
        );
    }
}
