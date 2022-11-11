package lotto.domain;

import lotto.dto.GameResultResponseDto;
import org.assertj.core.api.Assertions;
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

        GameResultResponseDto responseDto = Referee.calculate(lottoResults, 7000);
        Assertions.assertThat(responseDto.getEarningRate()).isEqualTo(428642.9D);
    }
}
