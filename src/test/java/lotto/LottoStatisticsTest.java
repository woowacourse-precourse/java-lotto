package lotto;

import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;
import lotto.model.statistics.LottoStatisticsGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    @DisplayName("6개 일치, 보너스 번호 일치 안할 시 1등")
    @Test
    void makeFirstLottoResultTest() {
        assertSimpleTest(() -> {
            LottoResult result = LottoResult.FIRST;
            assertThat(LottoResult.getLottoResult(6, false)).isEqualTo(result);
        });
    }

    @DisplayName("5개 일치, 보너스 번호 일치 시 2등")
    @Test
    void makeSecondLottoResultTest() {
        assertSimpleTest(() -> {
            LottoResult result = LottoResult.SECOND;
            assertThat(LottoResult.getLottoResult(5, true)).isEqualTo(result);
        });
    }

    @DisplayName("5개 일치, 보너스 번호 일치 안할 시 3등")
    @Test
    void makeThirdLottoResultTest() {
        assertSimpleTest(() -> {
            LottoResult result = LottoResult.THIRD;
            assertThat(LottoResult.getLottoResult(5, false)).isEqualTo(result);
        });
    }

    @DisplayName("4개 일치 시 4등")
    @Test
    void makeFourthLottoResultTest() {
        assertSimpleTest(() -> {
            LottoResult result = LottoResult.FOURTH;
            assertThat(LottoResult.getLottoResult(4, true)).isEqualTo(result);
        });
    }

    @DisplayName("3개 일치 시 5등")
    @Test
    void makeFifthLottoResultTest() {
        assertSimpleTest(() -> {
            LottoResult result = LottoResult.FIFTH;
            assertThat(LottoResult.getLottoResult(3, false)).isEqualTo(result);
        });
    }

    @DisplayName("로또 당첨 내역 테스트")
    @Test
    void getHistoryDescriptionTest() {
        assertSimpleTest(() -> {
            LottoStatisticsGenerator generator = new LottoStatisticsGenerator();
            List<LottoResult> lottoResults = List.of(
                    LottoResult.MISS,
                    LottoResult.FOURTH,
                    LottoResult.MISS,
                    LottoResult.THIRD,
                    LottoResult.THIRD,
                    LottoResult.MISS,
                    LottoResult.MISS,
                    LottoResult.FIFTH
            );

            LottoStatistics statistics = generator.generate(lottoResults);

            int result = 2;
            assertThat(statistics.getLottoResultCount(LottoResult.THIRD)).isEqualTo(result);
        });
    }

    @DisplayName("로또 당첨 수익금 테스트")
    @Test
    void getReturnRateDescriptionTest() {
        assertSimpleTest(() -> {
            LottoStatisticsGenerator generator = new LottoStatisticsGenerator();
            List<LottoResult> lottoResults = List.of(
                    LottoResult.MISS,
                    LottoResult.FOURTH,
                    LottoResult.MISS,
                    LottoResult.THIRD,
                    LottoResult.THIRD,
                    LottoResult.MISS,
                    LottoResult.MISS,
                    LottoResult.FIFTH
            );

            LottoStatistics statistics = generator.generate(lottoResults);

            int result = 3055000;
            assertThat(statistics.getTotalPrize()).isEqualTo(result);
        });
    }
}
