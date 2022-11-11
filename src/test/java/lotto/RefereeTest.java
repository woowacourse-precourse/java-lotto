package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @DisplayName("주어진 금액과 결과들을 토대로 수익률 계산")
    @Test
    void calculateEarningRate() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.FIFTH,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE);
        GameResultResponseDto responseDto = Referee.calculate(lottoResults, 8000);
        assertThat(responseDto.getEarningRate()).isEqualTo(62.5D);
    }

    @DisplayName("로또 결과를 토대로 게임의 결과를 반환하는 기능")
    @Test
    void calculateResult() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.FIFTH,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE,
                LottoResult.ELSE);

        GameResultResponseDto responseDto = Referee.calculate(lottoResults, 8000);
        assertThat(responseDto.getFirstDto().getTotalCount()).isEqualTo(0);
        assertThat(responseDto.getSecondDto().getTotalCount()).isEqualTo(0);
        assertThat(responseDto.getThirdDto().getTotalCount()).isEqualTo(0);
        assertThat(responseDto.getFourthDto().getTotalCount()).isEqualTo(0);
        assertThat(responseDto.getFifthDto().getTotalCount()).isEqualTo(1);
    }
}
