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

    @DisplayName("일반 로또 당첨 결과 설명은 '{일치 숫자 갯수}개 일치 ({당첨금액}원)'형식으로 나온다.")
    @Test
    void getNormalLottoResultDescriptionTest() {
        assertSimpleTest(() -> {
            String result = "3개 일치 (5,000원)";
            assertThat(LottoResult.FIFTH.getDescription()).isEqualTo(result);
        });
    }

    @DisplayName("2등 로또 당첨 결과 설명은 '{일치 숫자 갯수}개 일치, 보너스 볼 일치 ({당첨금액}원)'형식으로 나온다.")
    @Test
    void getSpecialLottoResultDescriptionTest() {
        assertSimpleTest(() -> {
            String result = "5개 일치, 보너스 볼 일치 (30,000,000원)";
            assertThat(LottoResult.SECOND.getDescription()).isEqualTo(result);
        });
    }

    @DisplayName("로또 당첨 내역 테스트")
    @Test
    void getHistoryDescriptionTest() {
        assertSimpleTest(() -> {
            LottoStatisticsGenerator generator = new LottoStatisticsGenerator(8000);
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

            String result = "3개 일치 (5,000원) - 1개\n" +
                    "4개 일치 (50,000원) - 1개\n" +
                    "5개 일치 (1,500,000원) - 2개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                    "6개 일치 (2,000,000,000원) - 0개";
            assertThat(statistics.getHistoryDescription()).isEqualTo(result);
        });
    }

    @DisplayName("로또 당첨 수익률 테스트")
    @Test
    void getReturnRateDescriptionTest() {
        assertSimpleTest(() -> {
            LottoStatisticsGenerator generator = new LottoStatisticsGenerator(8000);
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

            String result = "총 수익률은 38,187.5%입니다.";
            assertThat(statistics.getReturnRateDescription()).isEqualTo(result);
        });
    }
}
