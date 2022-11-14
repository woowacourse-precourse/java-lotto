package lotto.domain;

import lotto.dto.GameResultResponseDtos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.dto.GameResultResponseDtos.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @DisplayName("주어진 금액과 결과들을 토대로 수익률 계산")
    @Test
    void calculateEarningRate() {
        List<LottoResult> lottoResults = createLottoResults();

        GameResultResponseDtos responseDto = Referee.calculate(lottoResults, 8000);
        assertThat(responseDto.getEarningRate()).isEqualTo(62.5D);
    }

    private List<LottoResult> createLottoResults() {
        return List.of(
                LottoResult.FIFTH,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE);
    }

    @DisplayName("주어진 금액과 결과들을 토대로 통계값 계산")
    @Test
    void calculateStatistics() {
        List<LottoResult> lottoResults = createLottoResults();

        GameResultResponseDtos responseDtos = Referee.calculate(lottoResults, 8000);
        GameResultResponseDto responseDto = responseDtos.getGameResultResponseDtos().get(0);

        assertThat(responseDto.getSameNumberCount()).isEqualTo(3);
        assertThat(responseDto.getWinnerPrice()).isEqualTo(5000);
        assertThat(responseDto.getTotalCount()).isEqualTo(1);
    }


    @DisplayName("로또 결과의 수익률은 둘째 자리에서 반올림 테스트")
    @Test
    void calculateResult() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.FIFTH,
                LottoResult.SECOND,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE);

        GameResultResponseDtos responseDto = Referee.calculate(lottoResults, 7000);
        assertThat(responseDto.getEarningRate()).isEqualTo(428642.9D);
    }
}
